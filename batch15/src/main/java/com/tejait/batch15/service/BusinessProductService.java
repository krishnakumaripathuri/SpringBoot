package com.tejait.batch15.service;

import com.tejait.batch15.model.BusinessProduct;
import org.springframework.stereotype.Service;

@Service
public interface BusinessProductService {
    BusinessProduct getBusinessProducts(BusinessProduct product);

    BusinessProduct getAllProducts(Integer appId);
}
