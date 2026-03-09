package com.tejait.batch15.controller;

import com.tejait.batch15.dto.ApplicationOverview;
import com.tejait.batch15.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class ApplicationController {

        private final ApplicationService applicationService;

        @GetMapping("getOverviewDeatils/{appId}")
        public ApplicationOverview getOverview(@PathVariable Integer appId) {
                return applicationService.fetchAllApplication(appId);
        }
}

