package pl.unity.ulab1.shopping.application.query.view;

import java.math.BigDecimal;

/**
 * @author lsutula
 */
public class ProductFromCart {
	private String productName;
	private int productQuantity;
	private BigDecimal productPrice;

	public ProductFromCart(String productName, int productQuantity, BigDecimal productPrice) {
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}
}
