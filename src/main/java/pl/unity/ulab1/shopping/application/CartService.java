package pl.unity.ulab1.shopping.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;
import pl.unity.ulab1.shopping.domain.CartRepository;
import pl.unity.ulab1.shopping.domain.ProductID;
import pl.unity.ulab1.shopping.domain.eventbus.DomainEventBus;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;

/**
 * @author lsutula
 */
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private DomainEventBus eventBus;

	public Cart getCart(GetCartCommand command){
		CartID cartID = new CartID(command.cartID());
		return cartRepository.getCart(cartID);
	}

	@Transactional
	public void addProductToCart(AddProductToCartCommand command) throws ProductLimitReachedException {
		ProductID productID = new ProductID(command.productID());
		CartID cartID = new CartID(command.cartID());

		Cart cart = cartRepository.getCart(cartID);
		cart.addProduct(productID, command.productQuantity(), eventBus);

	}
}
