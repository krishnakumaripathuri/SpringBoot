package com.tejait.batch15.service;

import com.tejait.batch15.dto.ApplicationOverview;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationService {

    ApplicationOverview fetchAllApplication(Integer appId);
}
