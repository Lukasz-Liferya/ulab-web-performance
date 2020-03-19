package pl.unity.ulab1.shopping.domain;

import lombok.Getter;

/**
 * @author lsutula
 */
@Getter
public class ProductQuantityLimit {

	public static final int DEFAULT_QUANTITY_LIMIT = 100;
	public static ProductQuantityLimit defaultLimit = new ProductQuantityLimit(DEFAULT_QUANTITY_LIMIT);
	private int actualProductQuantity = 0;
	private int limit = 100;


	public ProductQuantityLimit(int quantityLimit) {
		this.limit = quantityLimit;
	}

	public ProductQuantityLimit(int actualProductQuantity, int quantityLimit) {
		this.actualProductQuantity = actualProductQuantity;
		this.limit = quantityLimit;
	}

	public ProductQuantityLimit newProductQuantity(int quantity){
		return new ProductQuantityLimit(this.actualProductQuantity + quantity, DEFAULT_QUANTITY_LIMIT);
	}

	public boolean isLimitReached(int productQuantity) {
		return this.actualProductQuantity + productQuantity > limit;
	}
}
