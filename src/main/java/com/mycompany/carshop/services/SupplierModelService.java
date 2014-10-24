/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.services;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.presentation.models.SupplierModel;
import java.util.List;

/**
 *
 * @author Mhumhu
 */
public interface SupplierModelService {
    public void addCarSupplier(SupplierModel model);
    public void deleteCarSupplier(Long id);
    public SupplierModel getCarSupplierToEdit(Long id);
    public AutoSupplier updateCarSupplier(SupplierModel model);
    public List<AutoSupplier> getCarSuppliers();
    
}
