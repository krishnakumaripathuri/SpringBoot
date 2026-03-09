package com.tejait.batch15.service;


import com.tejait.batch15.model.Loans;

import java.util.List;

public interface LoanService {

    Loans saveLoan(Loans loan);

    List<Loans> getAll();
}
