package pl.unity.ulab1.shopping.application.query.view;

import java.util.List;
import java.util.UUID;

/**
 * @author lsutula
 */
public interface CartSaleReportProjection {
	void createNewSaleReport(UUID buyerID, String buyerName, String buyerSurname, List<ProductFromCart> products);
	void updateSaleReport(UUID buyerID, String buyerName, String buyerSurname, List<ProductFromCart> products);
}
