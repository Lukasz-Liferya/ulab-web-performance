package pl.unity.ulab1.shopping.domain.sourcing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;

/**
 * @author lsutula
 */
@Entity
public class CartEvent {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	public CartEvent(ProductAddedToCart productAddedToCart) {
		//Generyczna persystencja eventu
	}
}
