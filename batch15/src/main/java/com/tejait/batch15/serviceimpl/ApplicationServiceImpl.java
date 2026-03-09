package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.dto.ApplicationOverview;
import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.repository.LoanRepository;
import com.tejait.batch15.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final BusinessProductRepository businessRepository;
    private final CompanyAddressRepository addressRepository;
    private final CompanyDetailsRepository detailsRepository;
    private LoanRepository loanRepository;



    @Override
    public ApplicationOverview fetchAllApplication(Integer appId) {

        ApplicationOverview dto = new ApplicationOverview();

        BusinessProduct product = businessRepository.findByAppId(appId).orElse(null);
        CompanyDetails details = detailsRepository.findByAppId(appId).orElse(null);
        CompanyAddress address = addressRepository.findByAppId(appId).orElse(null);
        Loans loans =  loanRepository.findByAppId(appId).orElseThrow(() -> new RuntimeException("Loan not found for ID: " + appId));

        dto.setAppId(appId);

        if(details !=null)
        {
            dto.setCompanyName(details.getCompanyName());
            dto.setCompanyPan(details.getCompanyPan());
        }

        if(loans !=null)

        {
            dto.setMobile((long) loans.getMobile());
            dto.setMail(loans.getMailId());
        }

        if(address !=null)

        {
            dto.setCity(address.getCity());
        }

        if(product !=null)

        {
            dto.setLoanAmt(product.getLoanAmount());
            dto.setTenure(product.getTenure());
        }

        return dto;
    }

}








