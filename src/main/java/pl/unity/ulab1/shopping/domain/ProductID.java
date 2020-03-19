package pl.unity.ulab1.shopping.domain;

import java.util.UUID;

import lombok.Getter;

/**
 * @author lsutula
 */
@Getter
public class ProductID {
	private UUID productID;
	public ProductID(UUID productID) {
		this.productID = productID;
	}
}
