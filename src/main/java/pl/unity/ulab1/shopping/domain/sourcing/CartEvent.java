package pl.unity.ulab1.shopping.domain.sourcing;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import pl.unity.ulab1.shopping.domain.eventbus.event.CartCreatedEvent;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;

/**
 * @author lsutula
 */
@Entity
@Getter
public class CartEvent {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartEvent.class);

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String event;

	@Enumerated(EnumType.STRING)
	private EventType type;

	private CartEvent() {
	}

	public CartEvent(ProductAddedToCart productAddedToCart) {
		try {
			event = new ObjectMapper().writeValueAsString(productAddedToCart);
			type = EventType.ProductAddedToCart;
		} catch (JsonProcessingException e) {
			LOGGER.error("Cannot map event to string", e);
		}
	}
	public CartEvent(CartCreatedEvent cartCreatedEvent) {
		try {
			event = new ObjectMapper().writeValueAsString(cartCreatedEvent);
			type = EventType.CartCreatedEvent;
		} catch (JsonProcessingException e) {
			LOGGER.error("Cannot map event to string", e);
		}
	}

	private enum EventType{
		ProductAddedToCart, CartCreatedEvent;
	}
}
