package pl.unity.ulab1.shopping.domain.sourcing;

import java.util.List;

/**
 * @author lsutula
 */
public class EventStream {
	private int version;
	private List<CartEvent> cartEvents;

	public List<CartEvent> cartEvents() {
		return cartEvents;
	}

	public int version() {
		return version;
	}
}
