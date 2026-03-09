package com.tejait.batch15.repository;

import com.tejait.batch15.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loans,Integer> {
    Optional<Loans> findByAppId(int appId);
}
