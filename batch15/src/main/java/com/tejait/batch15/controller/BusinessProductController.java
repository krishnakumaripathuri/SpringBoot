package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class BusinessProductController {
    BusinessProductService service;

    @PostMapping("saveProductDetails")
    public ResponseEntity<BusinessProduct> saveBusinessProduct(@RequestBody BusinessProduct product){
        BusinessProduct savedProducts= service.getBusinessProducts(product);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    @GetMapping("getProductDetails/{appId}")
    public ResponseEntity<BusinessProduct> getAllProducts(@PathVariable Integer appId){
        BusinessProduct allProducts = service.getAllProducts(appId);
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }
}

