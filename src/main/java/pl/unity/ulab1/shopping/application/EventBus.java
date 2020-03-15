package pl.unity.ulab1.shopping.application;

import org.springframework.stereotype.Component;

import pl.unity.ulab1.shopping.domain.eventbus.DomainEventBus;
import pl.unity.ulab1.shopping.domain.eventbus.event.CartCreatedEvent;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;

/**
 * @author lsutula
 */
@Component
public class EventBus implements DomainEventBus {

	public void post(CartCreatedEvent cartCreatedEvent) {
		//podpinamy stack Querry
		//1. Możemy wzbogacić zasilanie query w tym miejscu
		//2. Stack query może wzbogacać się sam
	}

	public void post(ProductAddedToCart productAddedToCart) {
		//podpinamy stack Querry
		//1. Możemy wzbogacić zasilanie query w tym miejscu
		//2. Stack query może wzbogacać się sam
	}
}
