package developer.controller;

import developer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/product", method = RequestMethod.GET)
    public ModelAndView getById(@RequestParam(name = "p_id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product");
        mv.addObject("product", productService.getById(id));
        return mv;
    }
}
