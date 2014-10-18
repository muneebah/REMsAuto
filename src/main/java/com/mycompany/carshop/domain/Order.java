/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Elton
 */
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private int orderNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderitem_id")
    private List<OrderItem> item;
    @OneToOne
    private Customer customer;
    @OneToOne
    private CustomerInvoice customerInvoice;
       
    public Order(){}
    
    private Order(Builder builder)
    {
        id = builder.id;
        orderNumber = builder.orderNumber;
        orderDate = builder.orderDate;
        item = builder.item;
        customer = builder.customer;
        customerInvoice = builder.customerInvoice;
       
    }
    public  static class Builder
    {
        private Long id;
        private int orderNumber;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date orderDate;
        List<OrderItem> item;
        Customer customer;
        CustomerInvoice customerInvoice;
                
        public Builder(int orderNumber)
        {
            this.orderNumber = orderNumber;
        }
        public Builder id(Long value)
        {
            id = value;
            return this;
        }
        public Builder orderDate(Date value)
        {
            orderDate = value;
            return this;
        }
        public Builder item(List<OrderItem> value)
        {
            item = value;
            return this;
        }
        public Builder customer(Customer value)
        {
            customer = value;
            return this;
        }
        public Builder customerInvoice(CustomerInvoice value)
        {
            customerInvoice = value;
            return this;
        }
        
        public Builder order(Order order)
        {
            id = order.getId();
            orderDate = order.getOrderDate();
            item = order.getItem();
            customer = order.getCustomer();
            customerInvoice = order.getCustomerInvoice();
            return this;
        }
       
        public Order build()
        {
            return new Order(this);
        }
        
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getItem() {
        return item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerInvoice getCustomerInvoice() {
        return customerInvoice;
    }

    public void setCustomerInvoice(CustomerInvoice customerInvoice) {
        this.customerInvoice = customerInvoice;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.Order[ id=" + id + " ]";
    }
    
}
