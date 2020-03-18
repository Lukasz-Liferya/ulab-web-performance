package pl.unity.ulab1.shopping.domain.sourcing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import pl.unity.ulab1.shopping.domain.CartID;

/**
 * @author lsutula
 */
@Entity
public class EventStream {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;

	@Embedded
	@AttributeOverride(name = "value", column = @Column(name = "cartID", nullable = false))
	private CartID cartID;

	@OneToMany(
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<CartEvent> cartEvents = new ArrayList<>();

	private EventStream() {
	}

	public EventStream(CartID cartID, List<CartEvent> cartEvents) {
		this.cartID = cartID;
		this.cartEvents = cartEvents;
	}

	public List<CartEvent> cartEvents() {
		return cartEvents;
	}

	public Long version() {
		return version;
	}

	@Override
	public String toString() {
		return "EventStream{" +
			"id=" + id +
			", version=" + version +
			", cartID=" + cartID +
			", cartEvents=" + cartEvents +
			'}';
	}
}
