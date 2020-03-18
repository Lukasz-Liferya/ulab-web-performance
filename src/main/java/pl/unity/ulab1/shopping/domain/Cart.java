package pl.unity.ulab1.shopping.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

import pl.unity.ulab1.shopping.domain.eventbus.event.CartCreatedEvent;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;
import pl.unity.ulab1.shopping.domain.sourcing.CartEvent;
import pl.unity.ulab1.shopping.domain.sourcing.EventStream;

/**
 * @author lsutula
 */
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@AttributeOverride(name = "value", column = @Column(name = "id", nullable = false))
	private CartID id;

	@Version
	private int version;

	int snapshotVersion;

	@Transient
	private ProductQuantityLimit productQuantityLimit;

	@Transient
	private List<CartProduct> cartProducts = new ArrayList<>();

	@ManyToOne
	private Buyer buyer;

	@Transient
	private List<CartEvent> changes = new ArrayList<>();

	private Cart() {
	}

	public Cart(EventStream eventStream) {
		Optional.ofNullable(eventStream).ifPresent(es -> {
			for (CartEvent event : es.cartEvents()) {
				//TODO rzutowanie CartEventu na konkretnyTypEventu np. ProductAddedToCart
				apply(new CartCreatedEvent());
			}
		});
		this.productQuantityLimit = ProductQuantityLimit.defaultLimit;
	}

	public void replayEvents(EventStream eventStream) {
		for (CartEvent event : eventStream.cartEvents()) {
			//TODO rzutowanie CartEventu na konkretnyTypEventu np. ProductAddedToCart
			apply(new CartCreatedEvent());
		}
	}


	private void apply(CartCreatedEvent cartCreatedEvent) {

	}
	private void apply(ProductAddedToCart productAddedToCart) {
		try {
			addProduct(productAddedToCart.productID(), productAddedToCart.productQuantity());
		} catch (ProductLimitReachedException e) {
			e.printStackTrace();
		}
	}
	private void apply(CardOrderd cardOrderd) {

	}

	public void addProduct(ProductID productID, int productQuantity) throws ProductLimitReachedException {
		if (this.productQuantityLimit.isLimitReached(productQuantity)){
			throw new ProductLimitReachedException();
		}
		this.productQuantityLimit = productQuantityLimit.newProductQuantity(productQuantity);
		addProductToCart(productID, productQuantity);
		ProductAddedToCart productAddedToCart = new ProductAddedToCart(productID, productQuantity);

		CartEvent cartEvent = new CartEvent(productAddedToCart);
		changes.add(cartEvent);
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

	public List<CartEvent> changes() {
		return changes;
	}

	public int snapshotVersion() {
		return snapshotVersion;
	}

}
