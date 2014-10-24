/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.controllers;

import com.mycompany.carshop.domain.AutoSupplier;
import com.mycompany.carshop.presentation.models.SupplierModel;
import com.mycompany.carshop.services.SupplierModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Mhumhu
 */
@Controller
@SessionAttributes
public class SuppliersController {
    @Autowired
    private SupplierModelService carSupplierService;
    
    @RequestMapping(value = "/supplierform", method = RequestMethod.GET)
    public String getCarSupplierForm(Model model) {
        SupplierModel carSupplierModel = new SupplierModel();
        model.addAttribute("SupplierModel", carSupplierModel);
        return "suppliers/form";
    }
    @RequestMapping(value = "/createsupplier", method = RequestMethod.POST)
    public String createSupplier(@ModelAttribute("SupplierModel") SupplierModel supplier,
            BindingResult result, Model model) {
        carSupplierService.addCarSupplier(supplier);

        List<AutoSupplier> suppliers = carSupplierService.getCarSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers";
    }
    
    @RequestMapping(value = "/suppliereditform", method = RequestMethod.GET)
    public String getSupplierEditForm(Model model) {
        SupplierModel CarSupplierModel = new SupplierModel();
        model.addAttribute("supplier", CarSupplierModel);
        return "suppliers/form";
    }
    
    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public String getSuppliers(Model model) {
        List<AutoSupplier> suppliers = carSupplierService.getCarSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers";
    }

    @RequestMapping(value = "/editsupplier", method = RequestMethod.GET)
    public String editSupplier(Model model, @ModelAttribute("SupplierModel") SupplierModel supplier) {
        carSupplierService.updateCarSupplier(supplier);
        
        List<AutoSupplier> suppliers = carSupplierService.getCarSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers";
    }

    @RequestMapping(value = "/deletesupplier", method = RequestMethod.GET,params = {"supplierId"})
    public String deleteSupplier(@RequestParam("supplierId") Long supplierId,Model model) {
        
        carSupplierService.deleteCarSupplier(supplierId);
        
        List<AutoSupplier> suppliers = carSupplierService.getCarSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers";
    }

    @RequestMapping(value = "private/editSupplierForm.html", method = RequestMethod.GET, params = {"supplierId"})
    public String editSupplierForm(@RequestParam("supplierId") String supplierId, Model model) {

        return "editSupplierForm";
    }
    
    
}
