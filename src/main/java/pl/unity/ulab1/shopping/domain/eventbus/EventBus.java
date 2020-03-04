package pl.unity.ulab1.shopping.domain.eventbus;

import pl.unity.ulab1.shopping.domain.eventbus.event.CartCreatedEvent;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;

/**
 * @author lsutula
 */
public interface EventBus {
	public void post(CartCreatedEvent cartCreatedEvent);
	public void post(ProductAddedToCart productAddedToCart);
}
