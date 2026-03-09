package com.tejait.batch15.service;

import com.tejait.batch15.model.CompanyDetails;

public interface CompanyDetailsService {

    CompanyDetails saveAllDetails(CompanyDetails details);

    CompanyDetails getCompanyDetails(Integer appId);
}


