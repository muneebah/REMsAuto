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
public class Asset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String autoName;
    @OneToOne
    private Automobile automobile;
    
    public Asset(){}
    
    private Asset(Builder builder) {
        id = builder.id;
        autoName = builder.autoName;
        automobile = builder.automobile;
    }
    
    public static class Builder
    {
        private Long id;
        private String autoName;
        Automobile automobile;
        
        public Builder(String autoName)
        {
            this.autoName = autoName;
        }
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder automobile(Automobile value) {
            this.automobile = value;
            return this;
        }
        
        public Builder asset(Asset asset)
        {
            id = asset.getId();
            autoName = asset.getAutoName();
            automobile = asset.getAutomobile();
            
            return this;
        }
        public Asset build()
        {
            return new Asset(this);
        }
    }
    public Long getId() {
        return id;
    }

    public String getAutoName() {
        return autoName;
    }

    public Automobile getAutomobile() {
        return automobile;
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
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.Asset[ id=" + id + " ]";
    }
    
}
