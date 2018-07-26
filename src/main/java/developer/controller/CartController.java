package developer.controller;

import developer.model.Cart;
import developer.model.Product;
import developer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(path = "/cart", method = RequestMethod.POST)
    public ModelAndView addToCart(@RequestAttribute("products") List<Product> products) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cart");
        Cart cart = new Cart();
        cart.setProducts(products);
        mv.addObject("cart", cartService.addCart(cart));
        return mv;
    }
}
