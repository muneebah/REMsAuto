/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.services;

import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.presentation.models.CustomerModel;
import java.util.List;

/**
 *
 * @author Mhumhu
 */
public interface CustomerModelService {
    public void addCustomer(CustomerModel model);
    public void deleteCustomer(Long id);
    public CustomerModel getCarSupplierToEdit(Long id);
    public Customer updateCustomer(CustomerModel model);
    public List<Customer> getCustomers();
}
