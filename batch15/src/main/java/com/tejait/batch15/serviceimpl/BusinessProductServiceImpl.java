package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.BusinessProduct;


import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BusinessProductServiceImpl implements BusinessProductService {

    BusinessProductRepository repository;

    @Override
    public BusinessProduct getBusinessProducts(BusinessProduct product) {
        return repository.save(product);
    }

    @Override
    public BusinessProduct getAllProducts(Integer appId) {
        return repository.findByAppId(appId).orElseThrow(()->new RuntimeException(""+appId));
    }
}
