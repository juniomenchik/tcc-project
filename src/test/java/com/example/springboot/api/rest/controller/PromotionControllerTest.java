package com.example.springboot.api.rest.controller;

import com.example.springboot.domain.service.promotion.PromotionService;
import com.example.springboot.persistence.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PromotionControllerTest {

    @InjectMocks
    PromotionController promotionController;

    @Mock
    PromotionService promotionService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExtraMoney() {
        Employee employee = new Employee();
        when(promotionService.extraMoney(any(Long.class))).thenReturn(employee);
        Employee response = promotionController.extraMoney(1L);
        assertEquals(employee, response);
        verify(promotionService, times(1)).extraMoney(any(Long.class));
    }

    @Test
    public void testNextLevel() {
        Employee employee = new Employee();
        when(promotionService.nextLevel(any(Long.class))).thenReturn(employee);
        Employee response = promotionController.nextLevel(1L);
        assertEquals(employee, response);
        verify(promotionService, times(1)).nextLevel(any(Long.class));
    }
}