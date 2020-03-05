package pl.unity.ulab1.shopping.application.query;

import java.util.UUID;

/**
 * @author lsutula
 */
public interface CartQueryService {
	CartDTO getCart(UUID id);
}
