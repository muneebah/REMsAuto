/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.domain.Orders;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.InventoryService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mhumhu
 */
public class IventoryServiceTest {
    public static ApplicationContext ctx;
    private InventoryService iventoryService;
    private OrderRepository orderRepository;
    private AutomobileTypeRepository automobileTypeRepository;
    
    public IventoryServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = false)
    public void testInventorService() {
    
        iventoryService = ctx.getBean(InventoryService.class);
        orderRepository = ctx.getBean(OrderRepository.class);
        automobileTypeRepository = ctx.getBean(AutomobileTypeRepository.class);
        
        List<AutomobileType> automobileTypes = automobileTypeRepository.findAll();
        AutomobileType autotype = automobileTypes.get(0);
        List<Automobile> automobiles = autotype.getAutomobiles();
        Automobile automobile = automobiles.get(0);
        int inventory = automobile.getInventory();

        List<Orders> orders = orderRepository.findAll();
        
        for(Orders order : orders) {
            iventoryService.processSale(order.getId());
        }
        
        automobileTypes = automobileTypeRepository.findAll();
        autotype = automobileTypes.get(0);
        automobiles = autotype.getAutomobiles();
        Automobile automobile2 = automobiles.get(0);
        
        Assert.assertEquals(--inventory, automobile2.getInventory());

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
