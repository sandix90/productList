package org.sandaix.productlist;

/**
 * Created by alex on 9/30/15.
 */
public class Product {
    String name;
    String category;
    String description;
    int imageIndex;

    public Product(String _name, String _category, int _imageIndex, String _description){
        this.name = _name;
        this.category = _category;
        this.imageIndex = _imageIndex;
        this.description = _description;
    }
}
