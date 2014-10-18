/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.services.MostSalesService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class MostSalesServiceImpl implements MostSalesService{
    
    @Autowired
    AutomobileTypeRepository automobileTypeRepository;
    
    @Override
    public AutomobileType getMostSalesAutomobile() {
        
        AutomobileType mostAutoTypeSales;
        
        List<AutomobileType> automobileTypes = automobileTypeRepository.findAll();
        
        Map<AutomobileType,Integer> sales = new HashMap<AutomobileType, Integer>();
        int highest = 0;
        
        for(AutomobileType autoType : automobileTypes) {
            List<Automobile> autotypes = autoType.getAutomobiles();
            int autoSales = 0;
                    
            for(Automobile auto : autotypes) {
                autoSales += auto.getSales();
            }
            sales.put(autoType, autoSales);
        }
        
        highest = sales.get(automobileTypes.get(0));
        mostAutoTypeSales = automobileTypes.get(0);
        
        for(AutomobileType automobileType : automobileTypes) {
            if(sales.get(automobileType) > highest) {
                 highest = sales.get(automobileType);
                 mostAutoTypeSales = automobileType;
            }
        }
        
        return mostAutoTypeSales;
    
    }
    
}
