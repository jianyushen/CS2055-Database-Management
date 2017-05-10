/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

/**
 *
 * @author Yu Qiu
 */
public class StoreInfoBean {
    private String storeID;
    private String address;
    private String manager;
    private int numofsales;
    private String region;
    
    public void setStoreID(String storeID){
        this.storeID = storeID;
    }
    
    public String getStoreID(){
        return this.storeID;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setManager(String manager){
        this.manager = manager;
    }
    
    public String getManager(){
        return this.manager;
    }
    
    public void setNumofsales(int numofsales){
        this.numofsales = numofsales;
    }
    
    public int getNumofsales(){
        return this.numofsales;
    }
    
    public void setRegion(String region){
        this.region = region;
    }
    
    public String getRegion(){
        return this.region;
    }
    
    
}
