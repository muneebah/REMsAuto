/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.domain.CustomerAddress;
import com.mycompany.carshop.domain.CustomerContact;
import com.mycompany.carshop.domain.CustomerName;
import com.mycompany.carshop.domain.Demographic;
import com.mycompany.carshop.presentation.models.CustomerModel;
import com.mycompany.carshop.repository.CustomerRepository;
import com.mycompany.carshop.services.CustomerModelService;
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
public class CustomerModelServiceImpl implements CustomerModelService{

    @Autowired
    private CustomerRepository customerService;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addCustomer(CustomerModel model) {
        
        Customer customer = new Customer(); 
        
        CustomerName name = new CustomerName();
        name.setFirstName(model.getFirstName());
        name.setLastName(model.getLastname());
        
        CustomerAddress address = new CustomerAddress();
        address.setPostalAddress(model.getPostalAddress());
        address.setStreetAddress(model.getStreetAddress());
        
        CustomerContact contact = new CustomerContact();
        contact.setPhoneNumber(model.getPhone());
        contact.setCellNumber(model.getCell());
        
        Demographic demo = new Demographic();
        demo.setGender(model.getGender());
        demo.setDateOfBirth(model.getDob());
        
        customer.setCustomerNumber(model.getCustNumber());
        customer.setCustomerName(name);
        customer.setCustomerAddress(address);
        customer.setCustomerContact(contact);
        customer.setDemographic(demo);
        
        customerService.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerService.delete(id);
    
    }

    @Override
    public CustomerModel getCarSupplierToEdit(Long id) {
        CustomerModel model = new CustomerModel();
        
        Customer customer = new Customer(); 
        
        CustomerName name = customer.getCustomerName();
                
        CustomerAddress address = customer.getCustomerAddress();
        
        CustomerContact contact = customer.getCustomerContact();
        
        Demographic demo = customer.getDemographic();
        
        
        model.setCustNumber(customer.getCustomerNumber());
        model.setFirstName(name.getFirstName());
        model.setLastname(name.getLastName());
        model.setPhone(contact.getPhoneNumber());
        model.setCell(contact.getCellNumber());
        model.setPostalAddress(address.getPostalAddress());
        model.setStreetAddress(address.getStreetAddress());
        model.setDob(demo.getDateOfBirth());
        model.setGender(demo.getGender());
        model.setCode(id);
        return model;
    
    }

    @Override
    public Customer updateCustomer(CustomerModel model) {
          Customer customer = new Customer();  
        
        CustomerName name = new CustomerName();
        name.setFirstName(model.getFirstName());
        name.setLastName(model.getLastname());
        
        CustomerAddress address = new CustomerAddress();
        address.setPostalAddress(model.getPostalAddress());
        address.setStreetAddress(model.getStreetAddress());
        
        CustomerContact contact = new CustomerContact();
        contact.setPhoneNumber(model.getPhone());
        contact.setCellNumber(model.getCell());
        
        Demographic demo = new Demographic();
        demo.setGender(model.getGender());
        demo.setDateOfBirth(model.getDob());
        
        customer.setCustomerNumber(model.getCustNumber());
        customer.setCustomerName(name);
        customer.setCustomerAddress(address);
        customer.setCustomerContact(contact);
        customer.setDemographic(demo);        
        customer.setId(model.getCode());
        
        return customerService.save(customer); }

    @Override
    public List<Customer> getCustomers() {
     return customerService.findAll();    
    }
    
}
