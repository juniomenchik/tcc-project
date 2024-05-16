package com.example.springboot.api.rest.controller.openapi;

import com.example.springboot.persistence.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;

public interface PromotionControllerOpenAPI {

    @Operation(summary = "Apply 20% promotion to an employee",
               description = "This operation receives an employee ID as parameter and increases the respective employee's salary by 20%.")
    Employee extraMoney(@PathVariable("id") Long id);

    @Operation(summary = "Apply a Level % promotion to an employee",
               description = "Given an employee's ID, this operation will a next level increase to the corresponding employee.")
    Employee nextLevel(@PathVariable("id") Long id);

}