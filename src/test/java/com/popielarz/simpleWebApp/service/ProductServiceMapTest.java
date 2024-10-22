package com.popielarz.simpleWebApp.service;

import com.popielarz.simpleWebApp.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

class ProductServiceMapTest {

    @Test
    public void testGetProducts() {
        ProductServiceMap productServiceMap = new ProductServiceMap();
        Collection<Product> products = productServiceMap.getProducts();
        Assertions.assertEquals(3, products.size());
    }

    @Test
    public void testGetProductsById() {
        ProductServiceMap productServiceMap = new ProductServiceMap();
        Product product103 = productServiceMap.getProductsById(103);
        Assertions.assertEquals(103, product103.getProdId());
        Assertions.assertEquals("Iphone 17", product103.getProdName());
        Assertions.assertEquals(6000, product103.getPrice());
    }

    @Test
    public void testGetProductsByIdMissingProduct() {
        // given
        ProductServiceMap productServiceMap = new ProductServiceMap();
        // when
        Product product103 = productServiceMap.getProductsById(-1);
        // then
        Assertions.assertEquals(100, product103.getProdId());
        Assertions.assertEquals("No Item", product103.getProdName());
        Assertions.assertEquals(0, product103.getPrice());
    }

    @Test
    public void testAddProduct() {
        // given
        ProductServiceMap productServiceMap = new ProductServiceMap();
        Product newProduct = new Product(104, "Ip 11 pro max", 4000);
        // when
        productServiceMap.addProduct(newProduct);
        // then
        Collection<Product> products = productServiceMap.getProducts();
        Assertions.assertEquals(4, products.size());
        Product product104 = productServiceMap.getProductsById(104);
        Assertions.assertEquals(104, product104.getProdId());
        Assertions.assertEquals("Ip 11 pro max", product104.getProdName());
        Assertions.assertEquals(4000, product104.getPrice());
    }

    @Test
    public void testDeleteProduct() {
        // given
        ProductServiceMap productServiceMap = new ProductServiceMap();
        // when
        productServiceMap.deleteProduct(102);
        // then
        Collection<Product> products = productServiceMap.getProducts();
        Assertions.assertEquals(2, products.size());
        Product product103 = productServiceMap.getProductsById(102);
        Assertions.assertEquals(100, product103.getProdId());
        Assertions.assertEquals("No Item", product103.getProdName());
        Assertions.assertEquals(0, product103.getPrice());

    }

    @Test
    public void testUpdateProduct() {
        // given
        ProductServiceMap productServiceMap = new ProductServiceMap();
        Product newProduct = new Product(102, "Ip 11 pro max", 5500);
        // when
        productServiceMap.updateProduct(newProduct);
        // then
        Product product102 = productServiceMap.getProductsById(102);
        Assertions.assertEquals("Ip 11 pro max", product102.getProdName());
    }


}