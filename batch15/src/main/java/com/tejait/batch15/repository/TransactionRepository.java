package com.tejait.batch15.repository;



import com.tejait.batch15.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {


    List<Transactions> findAllByAppId(Integer appId);
}

