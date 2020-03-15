package pl.unity.ulab1.shopping.domain;

import java.util.UUID;

import javax.persistence.Embeddable;

/**
 * @author lsutula
 */
@Embeddable
public class CartID {

	private UUID value;

	public CartID(UUID value) {
		this.value = value;
	}
}
