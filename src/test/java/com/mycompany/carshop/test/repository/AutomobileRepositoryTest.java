/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.Accessories;
import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.Colour;
import com.mycompany.carshop.repository.AutomobileRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.math.BigDecimal;
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
public class AutomobileRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private AutomobileRepository automobileRepository;
    
    
    public AutomobileRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createAutomobile() {
        automobileRepository = ctx.getBean(AutomobileRepository.class);
        
        Colour colour = new Colour();
        colour.setBodyColour("Black");
        colour.setInteriorColour("White");
        
        Accessories accessoty = new Accessories();
        accessoty.setAccessoryNumber("102031");
        accessoty.setAccessoryName("Seats Cover");
        accessoty.setUnitPrice(new BigDecimal(150.00));
        
        Automobile car = new Automobile.Builder("558 465 2CA")
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
     id = car.getId();
    Assert.assertNotNull(car);
     
     
    }

    @Test(dependsOnMethods = "createAutomobile", enabled = true)
    public void readAutomobile() {
        automobileRepository = ctx.getBean(AutomobileRepository.class);
        
        Automobile car = automobileRepository.findOne(id);
        Assert.assertEquals(car.getAutoName(),"BMW M3");
    }

    @Test(dependsOnMethods = "readAutomobile", enabled = true)
    private void updateAutomobile() {
        automobileRepository = ctx.getBean(AutomobileRepository.class);
        
        Colour colour = new Colour();
        colour.setBodyColour("Red");
        colour.setInteriorColour("black");
        
        
        Automobile car = automobileRepository.findOne(id);
        Automobile updateCar = new Automobile.Builder("558 465 2CA")
                .automobile(car)
                .colour(colour)
                .build();
        
        automobileRepository.save(updateCar);
        
        Automobile newCar = automobileRepository.findOne(id);
        Colour updateColour = newCar.getColour();
        Assert.assertEquals(updateColour.getBodyColour(), "Red");

    }

    @Test(dependsOnMethods = "updateAutomobile", enabled = true)
    private void deleteAutomobile() {

       automobileRepository = ctx.getBean(AutomobileRepository.class);
       
        Automobile car = automobileRepository.findOne(id);
        automobileRepository.delete(car);
        Automobile deletedCar = automobileRepository.findOne(id);
        
        Assert.assertNull(deletedCar);
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
