package com.tejait.batch15.controller;


import com.tejait.batch15.model.Loans;
import com.tejait.batch15.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class LoanController {

   private final LoanService service;

    @PostMapping("loanApply")
    public ResponseEntity<Loans> saveLoan(@RequestBody Loans loan){
        Loans savedLoan=service.saveLoan(loan);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }
    @GetMapping("loanTaskboard")
    public ResponseEntity<List<Loans>> getAll(){
        List<Loans> list =service.getAll();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }
}
