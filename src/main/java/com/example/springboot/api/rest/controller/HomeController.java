package com.example.springboot.api.rest.controller;

import com.example.springboot.api.rest.controller.openapi.HomeControllerOpenAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController implements HomeControllerOpenAPI {

    @PostMapping("/object")
    @Override
    public ResponseEntity<Object> createObject(@RequestBody Object obj) {
        return null;
    }

    @GetMapping("/object/{id}")
    @Override
    public ResponseEntity<Object> getObject(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/objects")
    @Override
    public ResponseEntity<List<Object>> getObjects() {
        return null;
    }

    @PutMapping("/object/{id}")
    @Override
    public ResponseEntity<Object> updateObject(@PathVariable Long id, @RequestBody Object obj) {
        return null;
    }

    @DeleteMapping("/object/{id}")
    @Override
    public ResponseEntity<Void> deleteObject(@PathVariable Long id) {
        return null;
    }
}