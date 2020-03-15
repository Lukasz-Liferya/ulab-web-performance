package pl.unity.ulab1.shopping.infrastructure.hibernate.query;

import java.util.UUID;

import org.springframework.stereotype.Component;

import pl.unity.ulab1.shopping.application.query.CartDTO;
import pl.unity.ulab1.shopping.application.query.CartQueryService;

/**
 * @author lsutula
 */
@Component
public class HibernateCartQueryService  implements CartQueryService {
	@Override
	public CartDTO getReportCart(UUID id) {
		return null;
	}
}
