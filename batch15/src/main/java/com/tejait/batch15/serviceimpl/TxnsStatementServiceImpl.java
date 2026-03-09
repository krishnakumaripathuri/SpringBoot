package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Transactions;


import com.tejait.batch15.repository.TransactionRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.List;

import java.util.stream.Collectors;

@Service

public class TxnsStatementServiceImpl {

    @Autowired

    private TransactionRepository transcationRepository;

    private static final DateTimeFormatter formatter =

            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<Transactions> getTransactions(Integer appId, String duration) {

        LocalDate today = LocalDate.now();

        LocalDate startDate;

        switch (duration.toLowerCase()) {

            case "last month":

                startDate = today.minusMonths(1);

                break;

            case "last 3 months":

                startDate = today.minusMonths(3);

                break;

            case "last 6 months":

                startDate = today.minusMonths(6);

                break;

            case "last year":

                startDate = today.minusYears(1);

                break;

            default:

                throw new RuntimeException("Invalid duration");

        }

        List<Transactions> transactions = transcationRepository.findAllByAppId(appId);

        return transactions.stream()

                .filter(txn -> {

                    // remove time part

                    String datePart = txn.getTransactionDate().substring(0,10);

                    LocalDate txnDate = LocalDate.parse(datePart, formatter);

                    return !txnDate.isBefore(startDate) && !txnDate.isAfter(today);

                })

                .collect(Collectors.toList());

    }

}