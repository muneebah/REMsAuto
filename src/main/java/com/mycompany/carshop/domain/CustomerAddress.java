/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mhumhu
 */
@Entity
public class CustomerAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String streetAddress;
    private String postalAddress;
    
     public CustomerAddress(){}
      private CustomerAddress(Builder builder)
      {
          id =builder.id;
          streetAddress = builder.streetAddress;
          postalAddress = builder.postalAddress;
                    
      }
     public static class Builder
     {
         private Long id;
        private String streetAddress;
        private String postalAddress;
        
         public Builder(String streetAddress)
          {
              this.streetAddress = streetAddress;
          }
         public Builder id(Long value)
         {
             id = value;
            return this;
         }
         public Builder postalAddress(String value)
        {
            postalAddress = value;
            return this;
        }
        public Builder customerAddress(CustomerAddress address)
        {
            id = address.getId();
            streetAddress = address.getStreetAddress();
            postalAddress = address.getPostalAddress();
            
            return this;
        }
        public CustomerAddress build()
        {
            return new CustomerAddress(this);
        }
     }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }
     
     
    public Long getId() {
        return id;
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
        if (!(object instanceof CustomerAddress)) {
            return false;
        }
        CustomerAddress other = (CustomerAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.CustomerAddress[ id=" + id + " ]";
    }
    
}
