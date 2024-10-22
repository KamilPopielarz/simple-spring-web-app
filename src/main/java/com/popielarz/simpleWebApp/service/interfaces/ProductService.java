package com.popielarz.simpleWebApp.service.interfaces;


import com.popielarz.simpleWebApp.model.Product;

import java.util.Collection;

//Interfejs jest to szczególny rodzaj klasy, który zawiera tylko sygnatury metod bez ich implementacji.
//Nie można zainicjalizowac interfejsu, czyli nie można stworzyć obiektu z interfejsu.
public interface ProductService {
    Collection<Product> getProducts();
    Product getProductsById(int prodId);

    void addProduct(Product addedProduct);

    void updateProduct(Product updatedProduct);

    void deleteProduct(int prodId);

}
