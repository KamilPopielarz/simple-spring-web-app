package com.popielarz.simpleWebApp.service;

import com.popielarz.simpleWebApp.model.Product;
import com.popielarz.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    Map<Integer, Product> products = new HashMap<>(Map.of(
            101, new Product(101, "Iphone 16", 5000),
            102, new Product(102, "Iphone 16 plus", 5500),
            103, new Product(103, "Iphone 17", 6000)));

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Product getProductsById(int prodId) {
        Product productToReturn = products.get(prodId);
        if (productToReturn == null) {
            return (new Product(100, "No Item", 0));
        }

        return productToReturn;
    }

    public void addProduct(Product addedProduct) {
        products.put(addedProduct.getProdId(), addedProduct);
    }

    public void updateProduct(Product updatedProduct) {
        if (products.containsKey(updatedProduct.getProdId())) {
            products.put(updatedProduct.getProdId(), updatedProduct);
        }
    }

    public void deleteProduct(int prodId) {
        products.remove(prodId);
    }
}
