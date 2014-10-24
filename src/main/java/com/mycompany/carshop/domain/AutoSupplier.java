/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Mhumhu
 */
@Entity
public class AutoSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supplierNumber;
    private String supplierName;
    private String supplierContact;
    private String supplierAddress;
    private String supplierEmail;
    
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "autosupplier_id")
    private List<Automobile> automobiles = new ArrayList<Automobile>();
    
    public AutoSupplier(){}
    
    private AutoSupplier(Builder builder)
    {
        id = builder.id;
        supplierNumber = builder.supplierNumber;
        supplierName = builder.supplierName;
        supplierContact = builder.supplierContact;
        supplierAddress = builder.supplierAddress;
        supplierEmail = builder.supplierEmail;
        automobiles =builder.automobiles;
    }
    public static class Builder{
        private Long id;
        private String supplierNumber;
        private String supplierName;
        private String supplierContact;
        private String supplierAddress;
        private String supplierEmail;
        List<Automobile> automobiles; 
                
        public Builder(String supplierNumber)
        {
            this.supplierNumber = supplierNumber;
        }
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder supplierName(String name)
        {
            this.supplierName = name;
            return this;
        }
        public Builder supplierContact(String contact)
        {
            this.supplierContact = contact;
            return this;
        }
        public Builder supplierAddress(String address)
        {
            this.supplierAddress = address;
            return this;
        }
        public Builder supplierEmail(String email)
        {
            this.supplierEmail = email;
            return this;
        }
        public Builder automobiles(List<Automobile> automobile)
        {
            this.automobiles = automobile;
            return this;
        }
        
        public Builder autoSupplier(AutoSupplier supplier)
        {
            this.id = supplier.getId();
            this.supplierContact = supplier.getSupplierContact();
            this.supplierAddress = supplier.getSupplierAddress();
            this.supplierEmail = supplier.getSupplierEmail();
            this.supplierName = supplier.getSupplierName();
            this.supplierNumber= supplier.getSupplierNumber();
            this.automobiles = supplier.getAutomobiles();
            
            return this;
        }
        public AutoSupplier build()
        {
            return new AutoSupplier(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public void setAutomobiles(List<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutoSupplier)) {
            return false;
        }
        AutoSupplier other = (AutoSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.AutoSupplier[ id=" + id + " ]";
    }
    
}

