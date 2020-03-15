package pl.unity.ulab1.shopping.application.command;

import javax.transaction.Transactional;

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
		}else {
			eventStream = cartEventStore.loadEventStream(cartID);
			cartSnapshot = new Cart(eventStream);
		}
		cartSnapshot.addProduct(new ProductID(command.productID()), command.productQuantity());

		cartEventStore.appendToStream(cartID, eventStream.version(), cartSnapshot.changes());
	}
}
