package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.service.CompanyAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyAddressServiceImpl implements CompanyAddressService {

    CompanyAddressRepository repository;

    @Override
    public CompanyAddress saveCompanyAddress(CompanyAddress company) {
        return repository.save(company);
    }

    @Override
    public CompanyAddress getAdress(Integer appId) {
        return repository.findByAppId(appId).orElseThrow(() -> new RuntimeException("" + appId));
    }
}
