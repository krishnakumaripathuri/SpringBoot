package com.tejait.batch15.service;

import com.tejait.batch15.model.Transactions;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TransactionService {

    List<Transactions> readTransactionsCsv(MultipartFile file);

    List<Transactions> saveTransactions(Long appId, List<Transactions> transactions);
}
