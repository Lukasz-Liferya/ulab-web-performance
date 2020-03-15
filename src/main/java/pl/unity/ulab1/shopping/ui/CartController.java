package pl.unity.ulab1.shopping.ui;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.unity.ulab1.shopping.application.command.AddProductToCartCommand;
import pl.unity.ulab1.shopping.application.command.CartService;

/**
 * @author lsutula
 */
@Controller
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping(value = "/cart/products")
	public ResponseEntity<String> getAllProducts(){
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@PostMapping(value = "/cart/addProduct")
	public ResponseEntity<String> addProduct(UUID cartID, UUID productID, int productQuantity){

		AddProductToCartCommand addProductToCartCommand = new AddProductToCartCommand(cartID, productID, productQuantity);

		cartService.addProductToCart(addProductToCartCommand);

		//DLA UPROSZCZENIA
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
