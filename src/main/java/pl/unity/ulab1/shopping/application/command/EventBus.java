package pl.unity.ulab1.shopping.application.command;

import org.springframework.beans.factory.annotation.Autowired;

import pl.unity.ulab1.shopping.application.query.view.CartSaleReportProjection;
import pl.unity.ulab1.shopping.domain.eventbus.DomainEventBus;
import pl.unity.ulab1.shopping.domain.eventbus.event.CartCreatedEvent;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;

/**
 * @author lsutula
 */
public class EventBus implements DomainEventBus {

	private CartSaleReportProjection cartSaleReportProjection;

	@Autowired
	public EventBus(CartSaleReportProjection cartSaleReportProjection) {
		this.cartSaleReportProjection = cartSaleReportProjection;
	}

	public void post(CartCreatedEvent cartCreatedEvent) {
		//podpinamy stack Querry
		//1. Możemy wzbogacić zasilanie query w tym miejscu
		//2. Stack query może wzbogacać się sam

		//TODO wyciągnięcie i transformacja danych z cartCreateEvent
		cartSaleReportProjection.createNewSaleReport(null, null,null,null);
	}

	public void post(ProductAddedToCart productAddedToCart) {
		//podpinamy stack Querry
		//1. Możemy wzbogacić zasilanie query w tym miejscu
		//2. Stack query może wzbogacać się sam
		cartSaleReportProjection.update(null, null,null,null);
	}
}
