package com.tejait.batch15.controller;

import com.tejait.batch15.model.Transactions;
import com.tejait.batch15.service.TranService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TranController {

    private final TranService service;

    // FETCH DATA
    @GetMapping("/getTxnsData/{appId}")
    public ResponseEntity<List<Transactions>> getTransactions(
            @PathVariable Long appId) {

        return ResponseEntity.ok(service.getTransactions(appId));
    }


    @GetMapping("/filtertransactions/{appId}")
    public List<Transactions> filterTransactions(
            @PathVariable Long appId,
            @RequestParam(required = false) String statusOrInstrument,
            @RequestParam(required = false) String statusOrInstrumentTypesList) {

        return service.filterTransactions(appId, statusOrInstrumentTypesList);
    }

    }





