/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.domain.Orders;
import com.mycompany.carshop.domain.OrderItem;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.InventoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class InventoryServiceImpl implements InventoryService{
     @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    AutomobileTypeRepository autoTypeRepository;

    @Override
    public void processSale(Long orderID) {
        Orders order = orderRepository.findOne(orderID);
        List<OrderItem> orderItems = order.getItem();
        
        for(OrderItem orderItem : orderItems) {
            int quantity = orderItem.getQuantity();
            Automobile automobile = orderItem.getAutomobile();

            if(automobile.getInventory()>= quantity) {
                int sales = automobile.getSales();
                sales += quantity;
                automobile.setSales(sales);
                
                int inventory = automobile.getInventory();
                inventory -= quantity;
                automobile.setInventory(inventory);

                AutomobileType automobileType = autoTypeRepository.findOne(automobile.getAutotypes().getId());
                List<Automobile> automobiles = automobileType.getAutomobiles();
                
                for(Automobile automobileUpdate : automobiles) {
                    if(automobileUpdate.getAutoName().equals(automobile.getAutoName())) {
                        automobiles.remove(automobileUpdate);
                        automobiles.add(automobile);
                        
                        automobileType.setAutomobiles(automobiles);
                        autoTypeRepository.save(automobileType);
                    }
                }
            }
        }
    
    }
    
}
