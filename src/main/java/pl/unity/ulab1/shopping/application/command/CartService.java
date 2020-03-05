package pl.unity.ulab1.shopping.application.command;

import java.util.Optional;

import javax.transaction.Transactional;

import pl.unity.ulab1.shopping.domain.Buyer;
import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;
import pl.unity.ulab1.shopping.domain.CartRepository;
import pl.unity.ulab1.shopping.domain.ProductID;
import pl.unity.ulab1.shopping.domain.ProductQuantityLimit;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;

/**
 * @author lsutula
 */
public class CartService {

	private CartRepository cartRepository;
	private EventBus eventBus;

	public Cart getCart(GetCartCommand command){
		CartID cartID = new CartID(command.cartID());
		return cartRepository.getCart(cartID);
	}

	@Transactional
	public void addProductToCart(AddProductToCartCommand command){
		ProductID productID = new ProductID(command.productID());
		CartID cartID = new CartID(command.cartID());
		//Koszyk może już istnieć lub nie
		Optional<Cart> optionalCart = cartRepository.findCart(cartID);

		try {
			if(optionalCart.isPresent()){
				Cart cart = optionalCart.get();
				cart.addProduct(productID, command.productQuantity(), eventBus);
			}else{
				Cart cart = new Cart(new ProductQuantityLimit(100), new Buyer());
				cart.addProduct(productID, command.productQuantity(), eventBus);
			}
		} catch (ProductLimitReachedException e) {
			e.printStackTrace();
		}
	}
}
