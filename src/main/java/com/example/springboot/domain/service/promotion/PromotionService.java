package com.example.springboot.domain.service.promotion;

import com.example.springboot.persistence.entity.Employee;

public interface PromotionService {
    Employee extraMoney(Long id);

    Employee nextLevel(Long id);
}
