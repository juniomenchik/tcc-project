package com.example.springboot.api.rest.controller.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface HomeControllerOpenAPI {

   @Operation(summary = "Create Object")
   ResponseEntity<Object> createObject(@RequestBody Object obj);
   @Operation(summary = "Get Object")
   ResponseEntity<Object> getObject(@PathVariable Long id);
   @Operation(summary = "Get All Objects")
   @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retrieve all objects")})
   ResponseEntity<List<Object>> getObjects();
   @Operation(summary = "Update Object")
   ResponseEntity<Object> updateObject(@PathVariable Long id, @RequestBody(description = "Object to be updated") Object obj);
   @Operation(summary = "Delete Object")
   @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Object deleted")})
   ResponseEntity<Void> deleteObject(@PathVariable Long id);
}