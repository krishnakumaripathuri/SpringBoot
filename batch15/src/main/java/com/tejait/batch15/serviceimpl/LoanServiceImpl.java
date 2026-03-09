package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Loans;
import com.tejait.batch15.repository.LoanRepository;
import com.tejait.batch15.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    LoanRepository repository;

    @Override
    public Loans saveLoan(Loans loan) {
        String fname =loan.getFname();
        String lname=loan.getLname();
        loan.setCustomerName(fname.concat(" "+lname));
        return repository.save(loan);
    }

    @Override
    public List<Loans> getAll() {
        return repository.findAll();
    }
}
