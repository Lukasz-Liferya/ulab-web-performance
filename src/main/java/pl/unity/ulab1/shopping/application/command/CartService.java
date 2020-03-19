package pl.unity.ulab1.shopping.application.command;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;
import pl.unity.ulab1.shopping.domain.CartRepository;
import pl.unity.ulab1.shopping.domain.ProductID;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;
import pl.unity.ulab1.shopping.domain.sourcing.CartEventStore;
import pl.unity.ulab1.shopping.domain.sourcing.EventStream;

/**
 * @author lsutula
 */
@Service
public class CartService {

	private CartRepository cartRepository;
	private CartEventStore cartEventStore;

	@Autowired
	public CartService(CartRepository cartRepository, CartEventStore cartEventStore) {
		this.cartRepository = cartRepository;
		this.cartEventStore = cartEventStore;
	}

	public Cart getCart(GetCartCommand command){
		CartID cartID = new CartID(command.cartID());
		return cartRepository.loadSnapshot(cartID, command.snapshotVersion());
	}

	@Transactional
	public void addProductToCart(AddProductToCartCommand command) throws ProductLimitReachedException {
		CartID cartID = new CartID(command.cartID());

		Cart cartSnapshot = cartRepository.loadSnapshot(cartID, command.snapshotVersion());

		EventStream eventStream;

		if(cartSnapshot!=null){
			eventStream = cartEventStore.loadEventStreamAfterVersion(cartID, cartSnapshot.snapshotVersion());
			cartSnapshot.replayEvents(eventStream);
			System.out.println("1111");
		}else {
			eventStream = cartEventStore.loadEventStream(cartID);
			if(eventStream!=null){
				cartSnapshot = new Cart(eventStream);
			}else {
				cartSnapshot = new Cart(command.buyer());
			}
		}

		cartSnapshot.addProduct(new ProductID(command.productID()), command.productQuantity());

		if(eventStream  == null) {
			eventStream = new EventStream(cartID, cartSnapshot.changes());
		}else{
			eventStream.cartEvents().addAll(cartSnapshot.changes());
		}
		cartEventStore.save(eventStream);
	}
}
