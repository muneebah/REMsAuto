/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.models;

import java.io.Serializable;

/**
 *
 * @author Mhumhu
 */
public class SupplierModel implements Serializable{
    private String supplierNumber;
    private String supplierName;
    private String supplierContact;
    private String supplierAddress;
    private String supplierEmail;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
    
    
}
