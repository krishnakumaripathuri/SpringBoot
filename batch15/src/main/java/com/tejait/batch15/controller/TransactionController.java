package com.tejait.batch15.controller;

import com.tejait.batch15.model.Transactions;
import com.tejait.batch15.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("sales")
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService service;

    // READ CSV FILE
    @PostMapping("/readTransactionsCsv")
    public ResponseEntity<List<Transactions>> readTransactionsCsv(
            @RequestParam("file") MultipartFile file) {

        List<Transactions> transactions = service.readTransactionsCsv(file);
        return ResponseEntity.ok(transactions);
    }

    // SAVE DATA
    @PostMapping("/saveTxnsData/{appId}")
    public ResponseEntity<List<Transactions>> saveTxnsData(
            @PathVariable Long appId,
            @RequestBody List<Transactions> transactions) {

        List<Transactions> savedData = service.saveTransactions(appId, transactions);
        return ResponseEntity.ok(savedData);
    }

}
