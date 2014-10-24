/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rhulani Baloyi
 */
@Entity
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int orderNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    
    @OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<OrderItem> item = new ArrayList<OrderItem>();
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name="invoice_id")
    private CustomerInvoice customerInvoice;

    public Orders(){}
    
    private Orders(Builder builder)
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
        
        public Builder order(Orders order)
        {
            id = order.getId();
            orderDate = order.getOrderDate();
            item = order.getItem();
            customer = order.getCustomer();
            customerInvoice = order.getCustomerInvoice();
            return this;
        }
       
        public Orders build()
        {
            return new Orders(this);
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.Orders[ id=" + id + " ]";
    }
    
    
}
