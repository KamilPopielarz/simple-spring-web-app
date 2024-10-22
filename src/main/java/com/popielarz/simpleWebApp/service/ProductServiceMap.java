package com.popielarz.simpleWebApp.service;

import com.popielarz.simpleWebApp.model.Product;
import com.popielarz.simpleWebApp.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceMap implements ProductService {

    Map<Integer, Product> products = new HashMap<>(Map.of(
            101, new Product(101, "Iphone 16", 5000),
            102, new Product(102, "Iphone 16 plus", 5500),
            103, new Product(103, "Iphone 17", 6000)));

    @Override
    public Collection<Product> getProducts() {
        return products.values();
    }
//    public List<Product> getProducts2() {
//        return products.values().stream().toList();
//    }

    @Override
    public Product getProductsById(int prodId) {
        Product productToReturn = products.get(prodId);
        if (productToReturn == null) {
            return (new Product(100, "No Item", 0));
        }

        return productToReturn;
    }

    @Override
    public void addProduct(Product addedProduct) {
        products.put(addedProduct.getProdId(), addedProduct);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        if (products.containsKey(updatedProduct.getProdId())) {
            products.put(updatedProduct.getProdId(), updatedProduct);
        }
    }

    @Override
    public void deleteProduct(int prodId) {
        products.remove(prodId);
    }
}
