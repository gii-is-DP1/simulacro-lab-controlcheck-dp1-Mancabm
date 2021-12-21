package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
    @Query("SELECT producttype FROM ProductType producttype")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
    @Query("SELECT producttype FROM ProductType producttype WHERE producttype.name =:name")
    ProductType getProductTypeByName(String name);
    @Query("SELECT product FROM Product product WHERE product.price <:precio")
    List<Product> findByPriceLessThan(Double precio);
}
