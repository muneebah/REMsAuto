/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author 210188200
 */
@Entity
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creditNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expiryDate;
    private String nameOnCreditCard;
    private BigDecimal balance;

    private CreditCard(Builder builder) {
        id = builder.id;
        creditNumber = builder.creditNumber;
        expiryDate = builder.expiryDate;
        nameOnCreditCard = builder.nameOnCreditCard;
        balance = builder.balance;
    }

    public CreditCard() {
    }

    public static class Builder {

        private Long id;
        private String creditNumber;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date expiryDate;
        private String nameOnCreditCard;
        private BigDecimal balance;

        public Builder(String creditNumber) {
            this.creditNumber = creditNumber;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder expiryDate(Date value) {
            this.expiryDate = value;
            return this;
        }

        public Builder nameOnCreditCard(String value) {
            this.nameOnCreditCard = value;
            return this;
        }

        public Builder balance(BigDecimal value) {
            this.balance = value;
            return this;
        }

        public Builder CreditCard(CreditCard value) {
            id = value.getId();
            creditNumber = value.getCreditNumber();
            expiryDate = value.getExpiryDate();
            nameOnCreditCard = value.getNameOnCreditCard();
            balance = value.getBalance();
            return this;
        }

        public CreditCard build() {
            return new CreditCard(this);
        }
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getNameOnCreditCard() {
        return nameOnCreditCard;
    }

    public BigDecimal getBalance() {
        return balance;
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
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.CreditCard[ id=" + id + " ]";
    }
    
}
