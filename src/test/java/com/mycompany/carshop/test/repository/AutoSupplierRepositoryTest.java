/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.repository.AutoSupplierRepository;
import com.mycompany.carshop.repository.AutomobileRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
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
public class AutoSupplierRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private AutomobileRepository automobileRepository;
    private AutoSupplierRepository autoSupplierRepository;
    
    public AutoSupplierRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test(enabled = true)
    public void createAutoSupplier() {
        automobileRepository = ctx.getBean(AutomobileRepository.class);
        autoSupplierRepository = ctx.getBean(AutoSupplierRepository.class);
            
     AutoSupplier supplier = new AutoSupplier.Builder("20102012")
                                .supplierName("BMW Factory")
                                .supplierContact("0769414940")
                                .supplierEmail("bmwfactory@gmail.com")
                                .supplierAddress("21 Jump street")
                                .build();
     autoSupplierRepository.save(supplier);
     id = supplier.getId();
     Assert.assertNotNull(supplier);
    }

    @Test(dependsOnMethods = "createAutoSupplier", enabled = true)
    public void readAutoSupplier() {
        
        autoSupplierRepository = ctx.getBean(AutoSupplierRepository.class);
        
        AutoSupplier supplier = autoSupplierRepository.findOne(id);
        Assert.assertEquals(supplier.getSupplierName(),"BMW Factory");
    }

    @Test(dependsOnMethods = "readAutoSupplier", enabled = false)
    private void updateAutoSupplier() {
      
       autoSupplierRepository = ctx.getBean(AutoSupplierRepository.class);
        
        
        AutoSupplier supplier = autoSupplierRepository.findOne(id);
        AutoSupplier newSupplier = new AutoSupplier.Builder("20102012")
                                       .autoSupplier(supplier)
                                       .supplierEmail("bmw@gmail.com")
                                       .build();
        
       autoSupplierRepository.save(newSupplier);
        Assert.assertEquals(newSupplier.getSupplierEmail(), "bmw@gmail.com");

    }

    @Test(dependsOnMethods = "updateAutoSupplier", enabled = false)
    private void deleteAutoSupplier() {

       autoSupplierRepository = ctx.getBean(AutoSupplierRepository.class);
       
        AutoSupplier supplier = autoSupplierRepository.findOne(id);
        autoSupplierRepository.delete(supplier);
        AutoSupplier deletedSupplier = autoSupplierRepository.findOne(id);
        
        Assert.assertNull(deletedSupplier);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = (ApplicationContext) new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
