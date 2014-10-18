/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services;

import com.mycompany.carshop.domain.AutoSupplier;

/**
 *
 * @author Mhumhu
 */
public interface SuppliersDetailsService {
    public AutoSupplier getSupplierInformation(Long supplierId);
        
}
