package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
    private final ProductService productService;

    @Autowired
    public ProductTypeFormatter(ProductService productService){
        this.productService = productService;
    }

    @Override
    public String print(ProductType object, Locale locale) {
        return object.name;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        List<ProductType> producttypes = productService.getAllProductTypes();
        for(ProductType p: producttypes){
            if(p.name.equals(text)){
                return p;
            }
        }
        throw new ParseException("Product type not found: " + text, 0);
    }
    
}
