package com.example.springboot.api.rest.controller;

import com.example.springboot.api.rest.controller.openapi.PromotionControllerOpenAPI;
import com.example.springboot.domain.service.promotion.PromotionService;
import com.example.springboot.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/promotions")
public class PromotionController implements PromotionControllerOpenAPI {

    @Autowired
    private PromotionService promotionService;

    @PutMapping("/money/{id}")
    @Override
    public Employee extraMoney(@PathVariable Long id) {
        log.info("Executing extraMoney with id {}", id);
        return promotionService.extraMoney(id);
    }

    @PutMapping("/level/{id}")
    @Override
    public Employee nextLevel(@PathVariable Long id) {
        log.info("Executing nextLevel with id {}", id);
        return promotionService.nextLevel(id);
    }
}