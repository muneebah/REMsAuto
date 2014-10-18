/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.repository.AutoSupplierRepository;
import com.mycompany.carshop.services.SuppliersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class SuppliersDetailsServiceImpl implements SuppliersDetailsService{

    @Autowired
    AutoSupplierRepository autoSupplierRepository;

    @Override
    public AutoSupplier getSupplierInformation(Long supplierId) {
       AutoSupplier supplier =  autoSupplierRepository.findOne(supplierId);
       
       supplier.getSupplierNumber();
       supplier.getSupplierName();
       supplier.getSupplierContact();
       supplier.getSupplierAddress();
       supplier.getSupplierEmail();
       
       return supplier;
    }
  
}
