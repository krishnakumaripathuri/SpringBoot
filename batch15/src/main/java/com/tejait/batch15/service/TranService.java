package com.tejait.batch15.service;

import com.tejait.batch15.model.Transactions;

import java.util.List;

public interface TranService {
    List<Transactions> getTransactions(Long appId);

    List<Transactions> filterTransactions(Long appId, String statusOrInstrumentTypesList);

}
