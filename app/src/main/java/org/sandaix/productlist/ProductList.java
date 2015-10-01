package org.sandaix.productlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 10/1/15.
 */
public class ProductList {
    private String name;
    private List<Product> productList;
    private String creationDateTime;


    public ProductList(String _name){
        this.name = _name;
        productList = new ArrayList<Product>();
    }

    public void addProduct(Product _product){
        productList.add(_product);

    }

}
