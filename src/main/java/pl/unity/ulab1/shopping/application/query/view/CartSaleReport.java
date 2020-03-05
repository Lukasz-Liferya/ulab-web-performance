package pl.unity.ulab1.shopping.application.query.view;

import java.util.List;

import javax.persistence.Entity;

/**
 * @author lsutula
 */
@Entity
public class CartSaleReport {
	private String buyerName;
	private String buyerSurname;
	//TODO w bazie danych to może być płaska struktura
	private List<ProductFromCart> products;
	private boolean discount;

	public CartSaleReport(String buyerName, String buyerSurname, List<ProductFromCart> products, boolean discount) {
		this.buyerName = buyerName;
		this.buyerSurname = buyerSurname;
		this.products = products;
	}
}
