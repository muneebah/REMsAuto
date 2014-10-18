/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Elton
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    @Embedded
    private CustomerName customerName;
    @OneToOne
    private CustomerAddress customerAddress;
    @Embedded
    private CustomerContact customerContact;
    @Embedded
    private Demographic demographic;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "creditcard_id")
    private List<CreditCard> creditCard;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<Order> order;

    public Customer(){
    }
    
    private Customer(Builder builder) {
        id = builder.id;
        customerNumber = builder.customerNumber;
        customerName = builder.customerName;
        customerContact = builder.customerContact;
        demographic = builder.demographic;
        customerAddress = builder.customerAddress;
        creditCard = builder.creditCard;
        order = builder.order; 
    }
    
    public static class Builder{
        private Long id;
        private String customerNumber;
        private CustomerName customerName;
        private CustomerAddress customerAddress;
        private CustomerContact customerContact;
        private Demographic demographic;
        List<CreditCard> creditCard;
        List<Order> order;

        public Builder(String customerNumber) {
            this.customerNumber = customerNumber;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder customerName(CustomerName name) {
            this.customerName = name;
            return this;
        }

        public Builder customerContact(CustomerContact contact) {
            this.customerContact = contact;
            return this;
        }

        public Builder demographic(Demographic demographic) {
            this.demographic = demographic;
            return this;
        }

        public Builder customerAddress(CustomerAddress customerAddress){
            this.customerAddress = customerAddress;
            return this;
        }
        public Builder creditCard(List<CreditCard> value)
        {
            creditCard = value;
            return this;
        }
        public Builder order(List<Order> value)
        {
            order = value;
            return this;
        }
        public Builder customer(Customer customer) {
            id = customer.getId();
            customerNumber = customer.getCustomerNumber();
            customerName = customer.getCustomerName();
            customerContact = customer.getCustomerContact();
            demographic = customer.getDemographic();
            customerAddress = customer.getCustomerAddress();
            creditCard = customer.getCreditCard();
            order = customer.getOrder();
            return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public List<Order> getOrder() {
        return order;
    }
    
    public CustomerName getCustomerName() {
        return customerName;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public CustomerContact getCustomerContact() {
        return customerContact;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public String getCustomerNumber() {
        return customerNumber;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.Customer[ id=" + id + " ]";
    }
    
}
