/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Mhumhu
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
    @ManyToOne
    private AutomobileType autotypes;
    @OneToOne(orphanRemoval=true,cascade= CascadeType.ALL)
    private MarketingInformation marketingInformation;
    
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
         marketingInformation = builder.marketingInformation;
        sales = builder.sales;
        accessory = builder.accessory;
        colour = builder.colour;
        autotypes = builder.autotypes;
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
        AutomobileType autotypes;
        MarketingInformation marketingInformation;
        
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
        public Builder autotypes(AutomobileType value)
        {
            this.autotypes = value;
            return this;
        }
        public Builder marketingInformation(MarketingInformation value)
        {
            marketingInformation = value;
            return this;
        }
        public Builder automobile(Automobile car) {
            id = car.getId();
            this.automobileNumber = car.getAutomobileNumber();
            this.autoName = car.getAutoName();
            this.manufacturer = car.getManufacturer();
            this.modelYear = car.getModelYear();
            this.inventory = car.getInventory();
            this.sales = car.getSales();
            this.unitPrice = car.getUnitPrice();
            this.accessory = car.getAccessory();
            this.colour = car.getColour();
            this.autotypes = car.getAutotypes();
            marketingInformation = car.getMarketingInformation();
            return this;
        }
        
        public Automobile build(){
            return new Automobile(this);
        }
        
    }

    public Long getId() {
        return id;
    }

    public String getAutomobileNumber() {
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
    public AutomobileType getAutotypes() {
        return autotypes;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public MarketingInformation getMarketingInformation() {
        return marketingInformation;
    }

    public void setMarketingInformation(MarketingInformation marketingInformation) {
        this.marketingInformation = marketingInformation;
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
