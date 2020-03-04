package pl.unity.ulab1.shopping.domain;

import java.math.BigDecimal;

/**
 * @author lsutula
 */
public class ProductPrice {
	private BigDecimal value;

	public ProductPrice(BigDecimal value) {
		assert value !=null;
		this.value = value;
	}
}
