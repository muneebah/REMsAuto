/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.restapi;

import com.mycompany.carshop.repository.AutoSupplierRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Rhulani Steff Baloyi
 */
@Controller
@RequestMapping("api")
public class SuppliersRestApi {
    @Autowired
    private AutoSupplierRepository suppliersService;
    
    @RequestMapping("suppliers")
    @ResponseBody
    public List<com.mycompany.carshop.domain.AutoSupplier> getCustomer(){
        return suppliersService.findAll();
    }
    
    
}
