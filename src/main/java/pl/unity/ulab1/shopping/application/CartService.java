package pl.unity.ulab1.shopping.application;

import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;
import pl.unity.ulab1.shopping.domain.CartRepository;
import pl.unity.ulab1.shopping.domain.ProductID;
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

	public void addProductToCart(AddProductToCartCommand command){
		ProductID productID = new ProductID(command.productID());
		CartID cartID = new CartID(command.cartID());
		Cart cart = cartRepository.getCart(cartID);
		try {
			cart.addProduct(productID, command.productQuantity(), eventBus);
		} catch (ProductLimitReachedException e) {
			//TODO exception
			e.printStackTrace();
		}
	}
}
