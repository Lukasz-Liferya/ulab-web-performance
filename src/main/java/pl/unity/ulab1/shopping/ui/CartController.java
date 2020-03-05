package pl.unity.ulab1.shopping.ui;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.unity.ulab1.shopping.application.command.AddProductToCartCommand;
import pl.unity.ulab1.shopping.application.command.CartService;

/**
 * @author lsutula
	*/
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(value = "/cart/addProduct", method = RequestMethod.POST)
	public ResponseEntity<String> addProduct(UUID cartID, UUID productID, int productQuantity){

		AddProductToCartCommand addProductToCartCommand = new AddProductToCartCommand(cartID, productID, productQuantity);
		cartService.addProductToCart(addProductToCartCommand);

		//DLA UPROSZCZENIA
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
