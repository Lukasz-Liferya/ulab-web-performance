package pl.unity.ulab1.shopping.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import pl.unity.ulab1.shopping.domain.eventbus.DomainEventBus;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;

/**
 * @author lsutula
 */
@Entity
public class Cart {

	private ProductQuantityLimit productQuantityLimit;
	private List<CartProduct> cartProducts = new ArrayList<>();
	private Buyer buyer;

	public Cart(ProductQuantityLimit productQuantityLimit, Buyer buyer) {
		this.productQuantityLimit = productQuantityLimit;
		this.buyer = buyer;
	}

	public void addProduct(ProductID productID, int productQuantity, DomainEventBus eventBus) throws ProductLimitReachedException {
		if (this.productQuantityLimit.isLimitReached(productQuantity)){
			throw new ProductLimitReachedException();
		}
		this.productQuantityLimit = productQuantityLimit.newProductQuantity(productQuantity);
		addProductToCart(productID, productQuantity);
		eventBus.post(new ProductAddedToCart(productID, new ProductQuantity(productQuantity)));
	}

	private void addProductToCart(ProductID productID, int productQuantity){
		Optional<CartProduct> existingProduct = this.cartProducts.stream()
			.filter(cartProduct -> cartProduct.isProductIDEquals(productID))
			.findFirst();

		if (existingProduct.isPresent()){
			existingProduct
				.ifPresent(cartProduct -> cartProduct.addQuantity(productQuantity));
		}else{
			this.cartProducts.add(new CartProduct(productID, productQuantity));
		}
	}
}
