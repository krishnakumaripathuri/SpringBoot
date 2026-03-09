package com.tejait.batch15.controller;


import com.tejait.batch15.model.Transactions;

import com.tejait.batch15.serviceimpl.TxnsStatementServiceImpl;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/loans")

public class TxnsStatementController {


    private final TxnsStatementServiceImpl service;

    public TxnsStatementController(TxnsStatementServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/fetchtransactions/{appId}")

    public List<Transactions> fetchTransactions(

            @PathVariable Integer appId,

            @RequestParam String duration) {

        return service.getTransactions(appId, duration);

    }

}