package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CompanyDetailsServiceimpl implements CompanyDetailsService {

    CompanyDetailsRepository repository;

    @Override
    public CompanyDetails saveAllDetails(CompanyDetails details) {
        return repository.save(details);
    }

    @Override
    public CompanyDetails getCompanyDetails(Integer appId) {
        return repository.findByAppId(appId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company details not found"));
    }
}




