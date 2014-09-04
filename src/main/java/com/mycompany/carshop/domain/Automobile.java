/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 210188200
 */
@Entity
public class Automobile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String automobileNumber;
    private String manufacturer;
    private String autoName;    
    private String modelYear;   
    private BigDecimal unitPrice;
    private int inventory;
    private int sales;
    
    @Embedded
    private Colour colour;
    @Embedded
    private Accessories accessory;
    
    public Automobile(){}
    private Automobile(Builder builder)
    {
        id = builder.id;
        automobileNumber = builder.automobileNumber;
        manufacturer = builder.manufacturer;
        autoName = builder.autoName;    
        modelYear = builder.modelYear;   
        unitPrice = builder.unitPrice;
        inventory = builder.inventory;
        sales = builder.sales;
        accessory = builder.accessory;
        colour = builder.colour;
    }
    public static class Builder
    {
        private Long id;
        private String automobileNumber;
        private String manufacturer;
        private String autoName;    
        private String modelYear;   
        private BigDecimal unitPrice;
        private int inventory;
        private int sales;
        private Accessories accessory;
        private Colour colour;
        
        public Builder(String automobileNumber)
        {
            this.automobileNumber = automobileNumber;
        }
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder manufacturer(String value) {
            this.manufacturer = value;
            return this;
        }

        public Builder autoName(String name) {
            this.autoName = name;
            return this;
        }

        public Builder modelYear(String year) {
            this.modelYear = year;
            return this;
        }

        public Builder unitPrice(BigDecimal price){
            this.unitPrice = price;
            return this;
        }
        public Builder inventory(int value)
        {
            this.inventory = value;
            return this;
        }
        public Builder sales(int value)
        {
            this.sales = value;
            return this;
        }
        public Builder accessory(Accessories value)
        {
            this.accessory = value;
            return this;
        }
        public Builder colour(Colour value)
        {
            this.colour = value;
            return this;
        }
        public Builder automobile(Automobile car) {
            id = car.getId();
            this.automobileNumber = car.getAutomoleNumber();
            this.autoName = car.getAutoName();
            this.manufacturer = car.getManufacturer();
            this.modelYear = car.getModelYear();
            this.inventory = car.getInventory();
            this.sales = car.getSales();
            this.unitPrice = car.getUnitPrice();
            this.accessory = car.getAccessory();
            this.colour = car.getColour();
            return this;
        }
        
        public Automobile build(){
            return new Automobile(this);
        }
        
    }

    public Long getId() {
        return id;
    }

    public String getAutomoleNumber() {
        return automobileNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getAutoName() {
        return autoName;
    }

    public String getModelYear() {
        return modelYear;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public int getSales() {
        return sales;
    }

    public Colour getColour() {
        return colour;
    }

    public Accessories getAccessory() {
        return accessory;
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automobile)) {
            return false;
        }
        Automobile other = (Automobile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.Automobile[ id=" + id + " ]";
    }
    
}
