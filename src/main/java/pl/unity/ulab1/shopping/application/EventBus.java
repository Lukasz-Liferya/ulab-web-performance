package pl.unity.ulab1.shopping.application;

import pl.unity.ulab1.shopping.domain.eventbus.DomainEventBus;
import pl.unity.ulab1.shopping.domain.eventbus.event.CartCreatedEvent;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;

/**
 * @author lsutula
 */
public class EventBus implements DomainEventBus {

	public void post(CartCreatedEvent cartCreatedEvent) {

	}

	public void post(ProductAddedToCart productAddedToCart) {

	}
}
