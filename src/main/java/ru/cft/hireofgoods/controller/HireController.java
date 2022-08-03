package ru.cft.hireofgoods.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import ru.cft.hireofgoods.repository.model.HireEntity;
import ru.cft.hireofgoods.service.HireService;


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
    public void postNewItem(@RequestBody HireEntity hireEntity) {
        this.hireService.createItem(hireEntity.getItemName(),
                                    hireEntity.getTraderId(),
                                    hireEntity.getCost());
    }

    @GetMapping("get/all-free-offers")
    public List<HireEntity> getAllFreeOffers(){
        return hireService.getAllFreeOffers();
    }

}
