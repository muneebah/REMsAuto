/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.Accessories;
import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.domain.Colour;
import com.mycompany.carshop.domain.MarketingInformation;
import com.mycompany.carshop.domain.Review;
import com.mycompany.carshop.repository.AutomobileRepository;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
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
public class AutomobileTypeRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private AutomobileTypeRepository automobileTypeRepository;
    private AutomobileRepository automobileRepository;
    
    public AutomobileTypeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createAutomobileType() {
        automobileRepository = ctx.getBean(AutomobileRepository.class);
        automobileTypeRepository = ctx.getBean(AutomobileTypeRepository.class);
        
        Colour colour = new Colour();
        colour.setBodyColour("Black");
        colour.setInteriorColour("White");
        
        Accessories accessoty = new Accessories();
        accessoty.setAccessoryNumber("102031");
        accessoty.setAccessoryName("Seats Cover");
        accessoty.setUnitPrice(new BigDecimal(150.00));
        
        Review review = new Review();
         review.setDescription("Good car");
         review.setRating(5);
         
         MarketingInformation marketingInformation = new MarketingInformation();
         marketingInformation.setStatusOfInformation("PENDING");         
         marketingInformation.setReview(review);
         
        Automobile car = new Automobile.Builder("558 465 2CA")
                                    .autoName("BMW M3")
                                    .manufacturer("BMW")
                                    .modelYear("2013")
                                    .unitPrice(new BigDecimal(120000.00))
                                    .sales(10)
                                    .inventory(30)
                                    .accessory(accessoty)
                                    .colour(colour)
                                    .marketingInformation(marketingInformation)
                                    .build();
     
     automobileRepository.save(car);
     
      Automobile car1 = new Automobile.Builder("558 465 2CB")
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
     
     List<Automobile> cars = new ArrayList<>();
     cars.add(car);
     cars.add(car1);
     
     AutomobileType type = new AutomobileType.Builder("Car")
                                .automobiles(cars)
                                .build();
     automobileTypeRepository.save(type);
     id = type.getId();
     Assert.assertNotNull(type);
    }

    @Test(dependsOnMethods = "createAutomobileType", enabled = true)
    public void readAutomobileType() {
        
        automobileTypeRepository = ctx.getBean(AutomobileTypeRepository.class);
        
        AutomobileType type = automobileTypeRepository.findOne(id);
        Assert.assertEquals(type.getAutoType(),"Car");
    }

    @Test(dependsOnMethods = "readAutomobileType", enabled = true)
    private void updateAutomobileType() {
      automobileRepository = ctx.getBean(AutomobileRepository.class);
       automobileTypeRepository = ctx.getBean(AutomobileTypeRepository.class);
        
        Colour colour = new Colour();
        colour.setBodyColour("Red");
        colour.setInteriorColour("black");
        
        
        Automobile car = automobileRepository.findOne(id);
        Automobile updateCar = new Automobile.Builder("558 465 2CA")
                .automobile(car)
                .colour(colour)
                .build();
        
        automobileRepository.save(updateCar);
        
        List<Automobile> cars = new ArrayList<>();
        cars.add(updateCar);
        
        AutomobileType type = automobileTypeRepository.findOne(id);
        AutomobileType newType = new AutomobileType.Builder("Car")
                                       .automobileType(type)
                                       .automobiles(cars)
                                       .build();
        
       automobileTypeRepository.save(newType);
        Assert.assertNotNull(newType);

    }

    @Test(dependsOnMethods = "updateAutomobileType", enabled = true)
    private void deleteAutomobileType() {

      automobileTypeRepository = ctx.getBean(AutomobileTypeRepository.class);
       
        AutomobileType type = automobileTypeRepository.findOne(id);
        automobileTypeRepository.delete(type);
        AutomobileType deletedType = automobileTypeRepository.findOne(id);
        
        Assert.assertNull(deletedType);
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
