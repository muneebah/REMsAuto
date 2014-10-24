/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.presentation.models.SupplierModel;
import com.mycompany.carshop.repository.AutoSupplierRepository;
import com.mycompany.carshop.services.SupplierModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mhumhu
 */
@Service
public class SupplierModelServiceImpl implements SupplierModelService{

    @Autowired
    private AutoSupplierRepository carSupplierService;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addCarSupplier(SupplierModel model) {
        
        AutoSupplier supplier = new AutoSupplier(); 
        supplier.setSupplierNumber(model.getSupplierNumber());
        supplier.setSupplierName(model.getSupplierName());
        supplier.setSupplierAddress(model.getSupplierAddress());
        supplier.setSupplierContact(model.getSupplierContact());
        supplier.setSupplierEmail(model.getSupplierEmail());
        
        carSupplierService.save(supplier);
            
    }

    @Override
    public void deleteCarSupplier(Long id) {
        carSupplierService.delete(id);
    }

    @Override
    public SupplierModel getCarSupplierToEdit(Long id) {
        SupplierModel model = new SupplierModel();
        
        AutoSupplier supplier = carSupplierService.findOne(id);
        
        model.setSupplierNumber(supplier.getSupplierNumber());
        model.setSupplierName(supplier.getSupplierName());
        model.setSupplierAddress(supplier.getSupplierAddress());
        model.setSupplierContact(supplier.getSupplierContact());
        model.setSupplierEmail(supplier.getSupplierEmail());
        model.setId(id);
        return model;
    
    }

    @Override
    public AutoSupplier updateCarSupplier(SupplierModel model) {
        AutoSupplier supplier = new AutoSupplier(); 
        
        supplier.setSupplierNumber(model.getSupplierNumber());
        supplier.setSupplierName(model.getSupplierName());
        supplier.setSupplierAddress(model.getSupplierAddress());
        supplier.setSupplierContact(model.getSupplierContact());
        supplier.setSupplierEmail(model.getSupplierEmail());
        
        supplier.setId(model.getId());
        return carSupplierService.save(supplier);
    
    }

    @Override
    public List<AutoSupplier> getCarSuppliers() {
        
    return carSupplierService.findAll();
    
    }
    
}
