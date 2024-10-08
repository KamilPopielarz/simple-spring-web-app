package com.popielarz.simpleWebApp.service;

import com.popielarz.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone 16", 5000),
            new Product(102, "Iphone 16 plus", 5500),
            new Product(103, "Iphone 17", 6000)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductsById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(100, "No Item", 0));
    }

    public void addProduct(Product addedProduct) {
        products.add(addedProduct);
    }

    public void updateProduct(Product updatedProduct) {
        int index = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProdId() == updatedProduct.getProdId())
                index = i;

            products.set(index, updatedProduct);
        }
    }

    public void deleteProduct(int prodId) {
        int index = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProdId() == prodId) {
                index = i;
                products.remove(index);
            }
        }
    }
}
