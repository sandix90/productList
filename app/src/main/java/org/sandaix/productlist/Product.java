package org.sandaix.productlist;

/**
 * Created by alex on 9/30/15.
 */
public class Product {
    String name;
    float price;
    String category;
    String description;
    float count;
    float weight;
    int imageIndex;

    public Product(String _name, float _price, String _category, float _count, float _weight, int _imageIndex, String _description){
        this.name = _name;
        this.price = _price;
        this.category = _category;
        this.count = _count;
        this.weight = _weight;
        this.imageIndex = _imageIndex;
        this.description = _description;
    }
}
