package com.tejait.batch15.repository;

import com.tejait.batch15.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transactions, Integer> {
    List<Transactions> findByAppId(Long appId);

    List<Transactions> findByAppIdAndTransactionStatusIn(Long appId, List<String> statuses);

    List<Transactions> findByAppIdAndInstrumentIn(Long appId, List<String> instruments);

    List<Transactions> findByAppIdAndTransactionStatusInAndInstrumentIn(
            Long appId,
            List<String> status,
            List<String> instrument
    );

}






