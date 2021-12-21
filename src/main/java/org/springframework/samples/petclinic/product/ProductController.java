package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public String createOrUpdateProduct(@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "products/createOrUpdateProductForm";
        } else{
            productService.save(product);
            return "welcome";
        }
    }
}
