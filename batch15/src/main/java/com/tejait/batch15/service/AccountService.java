package com.tejait.batch15.service;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;

public interface AccountService {

	Account saveAccount(Account account);

	Account getByAccountId(Long id);

	AccountResponseDto getByCustomerInfoByAccountId(Long id);

	AccountCustomerDto getByCustomerAccInfoByAccountId(Long id);

}
