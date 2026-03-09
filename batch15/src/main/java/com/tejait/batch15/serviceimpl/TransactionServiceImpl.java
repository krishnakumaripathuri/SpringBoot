package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Transactions;
import com.tejait.batch15.repository.TransactionRepository;
import com.tejait.batch15.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;


    @Override
    public List<Transactions> readTransactionsCsv(MultipartFile file) {

        List<Transactions> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(file.getInputStream()))) {

            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {

                if (header) {
                    header = false;
                    continue;
                }

                String[] data = line.split(",", -1); // IMPORTANT

                Transactions txn = new Transactions();

                txn.setTransactionDate(data[0]);
                txn.setActivity(data[1]);
                txn.setInstrument(data[2]);
                txn.setTxnId(data[3]);
                txn.setComment(data[4]);
                txn.setDebtAmt(data[5]);
                txn.setCreditAmt(data[6]);
                txn.setTransactionBreakup(data[7]);
                txn.setTransactionStatus(data[8]);

                transactions.add(txn);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }


    @Override
    public List<Transactions> saveTransactions(Long appId, List<Transactions> transactions) {
        transactions.forEach(txn -> txn.setAppId(appId));

        return repository.saveAll(transactions);
    }

}