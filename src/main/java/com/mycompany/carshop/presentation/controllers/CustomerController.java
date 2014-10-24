/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.controllers;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.presentation.models.CustomerModel;
import com.mycompany.carshop.presentation.models.SupplierModel;
import com.mycompany.carshop.services.CustomerModelService;
import com.mycompany.carshop.services.SupplierModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Mhumhu
 */
@Controller
@SessionAttributes
public class CustomerController {
    
     @Autowired
    private CustomerModelService customerService;
    
    @RequestMapping(value = "/customerform", method = RequestMethod.GET)
    public String getCustomerForm(Model model) {
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customerModel", customerModel);
        return "customers/custForm";
    }
    @RequestMapping(value = "/createcustomer", method = RequestMethod.POST)
    public String createCustomer(@ModelAttribute("customerModel") CustomerModel customer,
            BindingResult result, Model model) {
        customerService.addCustomer(customer);

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customers/customers";
    }
    
    @RequestMapping(value = "/customereditform", method = RequestMethod.GET)
    public String getCustomerEditForm(Model model) {
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customer", customerModel);
        return "customers/custForm";
    }
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customers/customers";
    }

    @RequestMapping(value = "/editcustomer", method = RequestMethod.GET)
    public String editCustomer(Model model, @ModelAttribute("customerModel") CustomerModel customer) {
        customerService.updateCustomer(customer);
        
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customers/customers";
    }

    @RequestMapping(value = "/deletecustomer", method = RequestMethod.GET,params = {"customerId"})
    public String deleteSupplier(@RequestParam("customerId") Long customerId,Model model) {
        
        customerService.deleteCustomer(customerId);
        
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customers/customers";
    }

    @RequestMapping(value = "private/editCustomerForm.html", method = RequestMethod.GET, params = {"customerId"})
    public String editCustomerForm(@RequestParam("customerId") String customerId, Model model) {

        return "editCustomerForm";
    }
    
    
}
