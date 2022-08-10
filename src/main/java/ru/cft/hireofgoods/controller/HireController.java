package ru.cft.hireofgoods.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import ru.cft.hireofgoods.repository.model.HireEntity;
import ru.cft.hireofgoods.service.HireService;


import java.math.BigDecimal;
import java.util.List;



@RestController
@RequestMapping("api/hire")
public class HireController {
    private HireService hireService;

    @Autowired
    public HireController(HireService hireService){
        this.hireService = hireService;
    }

    @GetMapping("get/all")
    public List<HireEntity> getAll(){
        return hireService.getAllHire();
    }

    @PostMapping("create-item")
    public void postNewItem(@RequestParam String name, @RequestParam long id, @RequestParam BigDecimal cost) {
        this.hireService.createItem(name, id, cost);
    }

    @GetMapping("get/all-free-offers")
    public List<HireEntity> getAllFreeOffers(){
        return hireService.getAllFreeOffers();
    }

    @PostMapping("hire-item")
    public void hireItem(@RequestParam long itemId, @RequestParam long consumerId){
        this.hireService.hireItem(itemId, consumerId);
    }

    @PostMapping("return-item")
    public void returnItem(@RequestParam long itemId){
        this.hireService.returnItem(itemId);
    }

    @GetMapping("return-all-users-hires")
    public List<HireEntity> getAllUsersOffers(@RequestParam long userId){
        return this.hireService.returnAllUsersHires(userId);
    }
}
