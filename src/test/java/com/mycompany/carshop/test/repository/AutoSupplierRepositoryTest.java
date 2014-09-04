/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.Accessories;
import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.Colour;
import com.mycompany.carshop.repository.AutoSupplierRepository;
import com.mycompany.carshop.repository.AutomobileRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
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
        
        Colour colour = new Colour();
        colour.setBodyColour("Black");
        colour.setInteriorColour("White");
        
        Accessories accessoty = new Accessories();
        accessoty.setAccessoryNumber("102031");
        accessoty.setAccessoryName("Seats Cover");
        accessoty.setUnitPrice(new BigDecimal(150.00));
        
        Automobile car = new Automobile.Builder("558 465 2CC")
                                    .autoName("BMW M3")
                                    .manufacturer("BMW")
                                    .modelYear("2013")
                                    .unitPrice(new BigDecimal(120000.00))
                                    .sales(10)
                                    .inventory(30)
                                    .accessory(accessoty)
                                    .colour(colour)
                                    .build();
     
     automobileRepository.save(car);
     
        Automobile car1 = new Automobile.Builder("558 465 2CD")
                                    .autoName("BMW M3i")
                                    .manufacturer("BMW")
                                    .modelYear("2014")
                                    .unitPrice(new BigDecimal(150000.00))
                                    .sales(9)
                                    .inventory(10)
                                    .accessory(accessoty)
                                    .colour(colour)
                                    .build();
     
     automobileRepository.save(car1);
     //id = car.getId();
   // Assert.assertNotNull(car);
     
     List<Automobile> cars = new ArrayList();
     cars.add(car);
     cars.add(car1);
     
     AutoSupplier supplier = new AutoSupplier.Builder("210017750")
                                .supplierName("BMW Factory")
                                .supplierContact("0769414940")
                                .supplierEmail("bmwfactory@gmail.com")
                                .supplierAddress("41 Peter Mokaba street")
                                .automobiles(cars)
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

    @Test(dependsOnMethods = "readAutoSupplier", enabled = true)
    private void updateAutoSupplier() {
      
       autoSupplierRepository = ctx.getBean(AutoSupplierRepository.class);
        
        
        AutoSupplier supplier = autoSupplierRepository.findOne(id);
        AutoSupplier newSupplier = new AutoSupplier.Builder("210017750")
                                       .autoSupplier(supplier)
                                       .supplierEmail("bmw@gmail.com")
                                       .build();
        
       autoSupplierRepository.save(newSupplier);
        Assert.assertEquals(newSupplier.getSupplierEmail(), "bmw@gmail.com");

    }

    @Test(dependsOnMethods = "updateAutoSupplier", enabled = true)
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
