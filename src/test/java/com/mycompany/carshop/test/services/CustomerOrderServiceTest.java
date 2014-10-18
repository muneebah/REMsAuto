/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.domain.CustomerInvoice;
import com.mycompany.carshop.domain.Order;
import com.mycompany.carshop.domain.OrderItem;
import com.mycompany.carshop.repository.CustomerInvoiceRepository;
import com.mycompany.carshop.repository.CustomerRepository;
import com.mycompany.carshop.repository.OrderItemRepository;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.CustomerOrderService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import static com.mycompany.carshop.test.repository.OrderRepositoryTest.ctx;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class CustomerOrderServiceTest {
    public static ApplicationContext ctx;
    private Long id;
    private OrderRepository orderRepository;
    private CustomerOrderService customerOrderService;
    private CustomerInvoiceRepository customerInvoiceRepo;
    private CustomerRepository customerRepository;
    private OrderItemRepository itemRepository;

    
    public CustomerOrderServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void tsetCustomerOrderService() {
        orderRepository = ctx.getBean(OrderRepository.class);
        customerOrderService = ctx.getBean(CustomerOrderService.class);
        customerInvoiceRepo = ctx.getBean(CustomerInvoiceRepository.class);
        customerRepository =  ctx.getBean(CustomerRepository.class);
        itemRepository = ctx.getBean(OrderItemRepository.class);
        
        // Get customer, create the customer's Order and CustomerInvoice before we can add automobiles to the Order.

        List<Customer> customers = customerRepository.findAll();
        
        Customer customer = customers.get(0);
        String customerNumber = customer.getCustomerNumber();
        Assert.assertNotNull("Testing CustomerOrderService customer not null",customerNumber);
        
        OrderItem item1 = new OrderItem.Builder(1)
                                .build();
        
          itemRepository.save(item1);
          
          OrderItem item2 = new OrderItem.Builder(2)
                                .build();
        
          itemRepository.save(item2);
          
          List<OrderItem> items = new ArrayList<>();
          items.add(item1);
          items.add(item2);
          
         Order order = new Order.Builder(425)
                .customer(customer)
                .orderDate(new Date())
                .item(items)
                .build();
   
        orderRepository.save(order);
        
        CustomerInvoice invoice = new CustomerInvoice.Builder("20583")
                                        .invoiceDate(new Date())
                                        .order(order)
                                        .orderAmount(new BigDecimal(150.00))
                                        .invoiceStatus("Paid")
                                        .build();
        
        customerInvoiceRepo.save(invoice);
        
        // Order an automobile, send the customers's Order ID and the AutomobileType's ID, the vehicle and how many.
        Map<String, String> autoDetails = new HashMap<String, String>();
        autoDetails.put("autoType", "Sedan");
        autoDetails.put("autoName", "Verso 1.6");
        customerOrderService.orderAutomobile(order.getId(), autoDetails, 1);
            
        
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
