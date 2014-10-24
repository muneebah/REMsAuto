/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author Rhulani Baloyi
 */
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    
    @OneToOne
    private Automobile automobile;

   
   public OrderItem(){
    }
    
    private OrderItem(Builder builder) {
        id = builder.id;
        automobile = builder.automobile;
        quantity = builder.quantity;
    }
    
    public static class Builder{
        private Long id;
        Automobile automobile;
        private int quantity;
           
        public Builder(int quantity) {
            this.quantity = quantity;
           
        }

        public Builder automobile(Automobile value) {
            this.automobile = value;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        
        public Builder orderItem(OrderItem orderItem) {
            this.id = orderItem.getId();
            this.automobile = orderItem.getAutomobile();
            this.quantity = orderItem.getQuantity();
            return this;
        }
        
        public OrderItem build(){
            return new OrderItem(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Automobile getAutomobile() {
        return automobile;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.OrderItem[ id=" + id + " ]";
    }
    
}
