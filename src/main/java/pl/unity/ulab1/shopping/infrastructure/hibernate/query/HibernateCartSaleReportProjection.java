package pl.unity.ulab1.shopping.infrastructure.hibernate.query;

import java.util.List;
import java.util.UUID;

import pl.unity.ulab1.shopping.application.query.view.CartSaleReport;
import pl.unity.ulab1.shopping.application.query.view.CartSaleReportProjection;
import pl.unity.ulab1.shopping.application.query.view.ProductFromCart;

/**
 * @author lsutula
 */
public class HibernateCartSaleReportProjection implements CartSaleReportProjection {

	@Override
	public void createNewSaleReport(UUID buyerID, String buyerName, String buyerSurname, List<ProductFromCart> products) {
		//TU wykonujemy dodatkowe operacje w stacku query
		boolean discountRequired = isDiscountRequired(buyerID);
		//Tu tworzymy encję
		CartSaleReport cartSaleReport = new CartSaleReport(buyerName, buyerSurname, products, discountRequired);
		repeository.save(cartSaleReport);
	}

	@Override
	public void updateSaleReport(UUID buyerID, String buyerName, String buyerSurname, List<ProductFromCart> products) {
		//TODO do implementacji
	}

	private boolean isDiscountRequired(UUID buyerID) {
		//TU możemy użyć innych usług do pobrania danych
		return false;
	}
}
