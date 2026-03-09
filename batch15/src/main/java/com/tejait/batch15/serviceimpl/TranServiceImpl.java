package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Transactions;
import com.tejait.batch15.repository.TransactionRepo;
import com.tejait.batch15.service.TranService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
@AllArgsConstructor

public class TranServiceImpl implements TranService {

    private final TransactionRepo repo;
    private static final Logger logger=getLogger(TranServiceImpl.class);


    @Override
    public List<Transactions> getTransactions(Long appId) {
        return repo.findByAppId(appId);
    }


    @Override
    public List<Transactions> filterTransactions(Long appId, String statusOrInstrumentTypesList) {

        if (statusOrInstrumentTypesList == null || statusOrInstrumentTypesList.trim().isEmpty()) {
            return repo.findByAppId(appId);
        }

        List<String> values = Arrays.asList(statusOrInstrumentTypesList.split(","));

        List<String> statusList = new ArrayList<>();
        List<String> instrumentList = new ArrayList<>();

        for (String value : values) {

            if (value.equalsIgnoreCase("SUCCESS") ||
                    value.equalsIgnoreCase("FAILED") ||
                    value.equalsIgnoreCase("PENDING") ||
                    value.equalsIgnoreCase("CANCELLED")) {

                statusList.add(value);
            }

            if (value.equalsIgnoreCase("UPI") ||
                    value.equalsIgnoreCase("WALLET") ||
                    value.equalsIgnoreCase("CREDITCARD") ||
                    value.equalsIgnoreCase("DEBITCARD")) {

                instrumentList.add(value);
            }
        }

        if (!statusList.isEmpty() && !instrumentList.isEmpty()) {
            return repo.findByAppIdAndTransactionStatusInAndInstrumentIn(appId, statusList, instrumentList);
        }

        if (!statusList.isEmpty()) {
            return repo.findByAppIdAndTransactionStatusIn(appId, statusList);
        }

        if (!instrumentList.isEmpty()) {
            return repo.findByAppIdAndInstrumentIn(appId, instrumentList);
        }

        return repo.findByAppId(appId);
    }


}



