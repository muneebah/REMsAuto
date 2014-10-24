/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Mhumhu
 */
@Entity
public class MarketingInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   private String statusOfInformation;
    @OneToOne
    private Review review;
    @OneToOne
    private Automobile automobile;
    
    public MarketingInformation(){}
    
    private MarketingInformation(Builder builder) {
        id = builder.id;
        automobile = builder.automobile;
        statusOfInformation = builder.statusOfInformation;
        review = builder.review;
    }
    
    public static class Builder{
        private Long id;
        Automobile automobile;
        Review review;
        private String statusOfInformation;
           
        public Builder(String statusOfInformation) {
            this.statusOfInformation = statusOfInformation;
           
        }

        public Builder automobile(Automobile value) {
            this.automobile = value;
            return this;
        }
        public Builder review(Review value) {
            this.review = value;
            return this;
        }
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        
        public Builder MarketingInformation(MarketingInformation market) {
            this.id = market.getId();
            this.automobile = market.getAutomobile();
            this.review = market.getReview();
            statusOfInformation = market.getStatusOfInformation();
            return this;
        }
        
        public MarketingInformation build(){
            return new MarketingInformation(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusOfInformation() {
        return statusOfInformation;
    }

    public void setStatusOfInformation(String statusOfInformation) {
        this.statusOfInformation = statusOfInformation;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
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
        if (!(object instanceof MarketingInformation)) {
            return false;
        }
        MarketingInformation other = (MarketingInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.MarketingInformation[ id=" + id + " ]";
    }
    
}

