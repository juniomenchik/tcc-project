//package com.example.springboot.api.rest.controller.web;
//
//import com.example.springboot.api.rest.dto.EmployeeDTO;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class EmployeeWebTest {
//
//    WebDriver driver;
//    ObjectMapper objectMapper;
//
//    @BeforeEach
//    public void setup() {
//        driver = new EdgeDriver();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    public void apiTests() throws JsonProcessingException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//        testGetAllEmployees();
//        testGetEmployee();
//        testCreateEmployee();
//        testUpdateEmployee();
//        testDeleteEmployee();
//    }
//
//    private void testCreateEmployee() throws JsonProcessingException {
//        driver.get("http://localhost:8000/api/employees");
//
//        EmployeeDTO newEmployee = new EmployeeDTO();
//        // set the fields of the newEmployee object
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("employee", newEmployee);
//        WebElement body = driver.findElement(By.tagName("body"));
//        body.sendKeys(objectMapper.writeValueAsString(params));
//
//        WebElement submitButton = driver.findElement(By.cssSelector("button"));
//        submitButton.click();
//
//        // Add assertions for the response
//    }
//
//    private void testGetEmployee() {
//        driver.get("http://localhost:8000/api/employees/1");
//
//        System.out.println(driver.findElement(By.tagName("body")));
//        // Add assertions for the response
//    }
//
//    private void testGetAllEmployees() {
//        driver.get("http://localhost:8000/api/employees");
//
//        System.out.println(driver.findElement(By.tagName("body")));
//        // Add assertions for the response
//    }
//
//    private void testUpdateEmployee() throws JsonProcessingException {
//        driver.get("http://localhost:8000/api/employees/1");
//
//        EmployeeDTO updateEmployee = new EmployeeDTO();
//        // set the fields of the updateEmployee object
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("employee", updateEmployee);
//        WebElement body = driver.findElement(By.tagName("body"));
//        body.sendKeys(objectMapper.writeValueAsString(params));
//
//        WebElement submitButton = driver.findElement(By.cssSelector("button"));
//        submitButton.click();
//
//        // Add assertions for the response
//    }
//
//    private void testDeleteEmployee() {
//        driver.get("http://localhost:8000/api/employees/1/delete");
//
//        // Add assertions for the response
//    }
//
//    @AfterEach
//    public void teardown() {
//        driver.quit();
//    }
//}