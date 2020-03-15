package pl.unity.ulab1.shopping.application.query.view;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author lsutula
 */
@Entity
public class CartSaleReport {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String buyerName;
	private String buyerSurname;
	//TODO w bazie danych to może być płaska struktura
	@Transient
	private List<ProductFromCart> products;
	private boolean discount;

	public CartSaleReport(String buyerName, String buyerSurname, List<ProductFromCart> products, boolean discount) {
		this.buyerName = buyerName;
		this.buyerSurname = buyerSurname;
		this.products = products;
	}
}
