/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Elton
 */
@Entity
public class CustomerInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String invoiceNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date invoiceDate;
    private BigDecimal orderAmount;
    private String invoiceStatus;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    public CustomerInvoice(){
    }
    
    private CustomerInvoice(CustomerInvoice.Builder builder) {
        id = builder.id;
        invoiceDate = builder.invoiceDate;
        orderAmount = builder.orderAmount;
        invoiceNumber = builder.invoiceNumber;
        invoiceStatus = builder.invoiceStatus;
        order = builder.order;
    }
    
    public static class Builder{
        private Long id;
        private Date invoiceDate;
        private BigDecimal orderAmount;
        private String invoiceNumber;
        private String invoiceStatus;
        Order order;
        
        public Builder(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }
        
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder order(Order value)
        {
            this.order = value;
            return this;
        }
        public Builder invoiceDate(Date value) {
            this.invoiceDate = value;
            return this;
        }
        public Builder invoiceStatus(String value) {
            this.invoiceStatus = value;
            return this;
        }
        public Builder orderAmount(BigDecimal orderAmount) {
            this.orderAmount = orderAmount;
            return this;
        }

        public Builder customerInvoice(CustomerInvoice customerInvoice) {
            this.id = customerInvoice.getId();
            this.invoiceDate = customerInvoice.getInvoiceDate();
            this.orderAmount = customerInvoice.getOrderAmount();
            this.invoiceNumber = customerInvoice.getInvoiceNumber();
            this.invoiceStatus = customerInvoice.getInvoiceStatus();
            this.order = customerInvoice.getOrder();
            return this;
        }
        
        public CustomerInvoice build(){
            return new CustomerInvoice(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
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
        if (!(object instanceof CustomerInvoice)) {
            return false;
        }
        CustomerInvoice other = (CustomerInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.CustomerInvoice[ id=" + id + " ]";
    }
    
}
