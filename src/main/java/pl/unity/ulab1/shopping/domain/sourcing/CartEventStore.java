package pl.unity.ulab1.shopping.domain.sourcing;

import java.util.List;

import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;

/**
 * @author lsutula
 */
public interface CartEventStore {
	EventStream loadEventStream(CartID cartID);
	EventStream loadEventStreamAfterVersion(CartID cartID,int snapshotVersion);
	void appendToStream(CartID cartID, int version, List<CartEvent> events);
	Cart loadLastSnapshot(CartID cartID);
}
