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

/**
 *
 * @author Mhumhu
 */
@Entity
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int rating;
   private String description;
   
   public Review(){}
    
    private Review(Builder builder) {
        id = builder.id;
        description = builder.description;
        rating = builder.rating;
    }
    
    public static class Builder{
        private Long id;
        private String description;
        private int rating;
           
        public Builder(String description) {
            this.description = description;
           
        }
        public Builder rating(int value) {
            this.rating = value;
            return this;
        }
                public Builder id(Long id) {
            this.id = id;
            return this;
        }
        
        public Builder Review(Review review) {
            this.id = review.getId();
            description = review.getDescription();
            rating = review.getRating();
            return this;
        }
        
        public Review build(){
            return new Review(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.Review[ id=" + id + " ]";
    }
    
}

