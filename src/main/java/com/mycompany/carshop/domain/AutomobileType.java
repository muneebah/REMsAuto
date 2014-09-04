/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 210188200
 */
@Entity
public class AutomobileType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String autoType;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "automobiletype_id")
    private List<Automobile> automobiles = new ArrayList<Automobile>();
    
    public AutomobileType(){}
    
    private  AutomobileType(Builder builder)
    {
        id = builder.id;
        autoType = builder.autoType;
        automobiles = builder.automobiles;
    }
    public static class Builder
    {
        private Long id;
        private String autoType;
        List<Automobile> automobiles;
        
        public Builder(String autoType)
        {
            this.autoType = autoType;
        }
        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }
        public Builder automobiles(List<Automobile> values)
        {
            this.automobiles = values;
            return this;
        }
        
        public Builder automobileType(AutomobileType type)
        {
            id = type.getId();
            autoType = type.getAutoType();
            automobiles = type.getAutomobiles();
            return this;
        }
        public AutomobileType build()
        {
            return new AutomobileType(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getAutoType() {
        return autoType;
    }

    public List<Automobile> getAutomobiles() {
        return automobiles;
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
        if (!(object instanceof AutomobileType)) {
            return false;
        }
        AutomobileType other = (AutomobileType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carshop.domain.AutomobileType[ id=" + id + " ]";
    }
    
}
