package pl.unity.ulab1.shopping.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;

/**
 * @author lsutula
 */
@Embeddable
public class CartID implements Serializable {

	private UUID value;

	private CartID() {
	}

	public CartID(UUID value) {
		this.value = value;
	}
}
