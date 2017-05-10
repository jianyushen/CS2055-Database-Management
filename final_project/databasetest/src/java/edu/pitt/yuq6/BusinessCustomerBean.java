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
public class BusinessCustomerBean {
    private String username;
    private String companyname;
    private String phone;
    private String email;
    private String address;
    private String zipcode;
    private int income;
    private String businessCategory;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    
    
    public String getUsername() {
        return username;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public int getIncome() {
        return income;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }
    
    
}
