/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

/**
 *
 * @author Toan
 */
public class ProductDTO {

    private int productId;
    private String productName;
    private double price;
    private String image;
    private int categoryId; 

    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName, double price, String image, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
