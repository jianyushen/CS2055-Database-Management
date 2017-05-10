/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.xinying;

/**
 *
 * @author pc
 */
public class ShoppingCartBean {
    private String productID;
    private String customerID;
    private String shopping_date;
    private String product_name;
    private int quatity;
    private double price;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the shopping_date
     */
    public String getShopping_date() {
        return shopping_date;
    }

    /**
     * @param shopping_date the shopping_date to set
     */
    public void setShopping_date(String shopping_date) {
        this.shopping_date = shopping_date;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the quatity
     */
    public int getQuatity() {
        return quatity;
    }

    /**
     * @param quatity the quatity to set
     */
    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
