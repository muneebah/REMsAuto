/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.repository.AutoSupplierRepository;
import com.mycompany.carshop.services.SuppliersDetailsService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mhumhu
 */
public class SuppliersDetailsServiceTest {
    private AutoSupplierRepository autoSupplierRepository;
    private SuppliersDetailsService supplierRepository;
    public static ApplicationContext ctx;
    
    public SuppliersDetailsServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void getCustomerAddress() {
        
    autoSupplierRepository = ctx.getBean(AutoSupplierRepository.class);
    supplierRepository = ctx.getBean(SuppliersDetailsService.class);
        
        List<AutoSupplier> suppliers = autoSupplierRepository.findAll();
        
        AutoSupplier supplier = suppliers.get(0);
        AutoSupplier supplierInfo = supplierRepository.getSupplierInformation(supplier.getId());
        Assert.assertNotNull(supplierInfo);
        
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
