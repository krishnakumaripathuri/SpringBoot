package com.tejait.batch15.repository;

import com.tejait.batch15.model.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {

    public Optional<CompanyDetails> findByAppId(int appId);
}
