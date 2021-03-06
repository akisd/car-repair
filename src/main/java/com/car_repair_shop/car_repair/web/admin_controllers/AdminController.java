package com.car_repair_shop.car_repair.web.admin_controllers;


import com.car_repair_shop.car_repair.domain.Repair;
import com.car_repair_shop.car_repair.services.repair.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = {"/admin/home", "/admin"}, method = RequestMethod.GET)
    String getAdminView(Model model) {
        List<Repair> repairs = repairService.getDailyServices();
        model.addAttribute("repairs" , repairs);

        return "/admin/home";
    }
}
