package com.popielarz.simpleWebApp.controller;

import com.popielarz.simpleWebApp.model.Product;
import com.popielarz.simpleWebApp.service.ProductServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceList service;

    @GetMapping("/products")
    public Collection<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductsById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod) {
        System.out.println(prod);
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod) {
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
    }

    @GetMapping("/products/query/{price}")
    public List<Product> getProductByPrice(@PathVariable int price) {
        return service.findByPriceGreaterThan(price);
    }

}
