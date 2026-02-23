package com.tejait.batch15.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountResponseDto {
	private Long accountId;
	private String accountType;
	private String holderName;
	private String ifsc;
	private String kycStatus;
	
	
	
}
