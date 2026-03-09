package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class CompanyDetailsController {

    CompanyDetailsService service;

    @PostMapping("saveCompanyDetails")
    public ResponseEntity<CompanyDetails> saveDetails(@RequestBody CompanyDetails details){
        CompanyDetails savedDetails=service.saveAllDetails(details);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }

    @GetMapping("getCompanyDetails/{appId}")
    public ResponseEntity<CompanyDetails> getByEmpId(@PathVariable Integer appId) {
        CompanyDetails company = service.getCompanyDetails(appId);
        return ResponseEntity.ok(company);

    }
}
