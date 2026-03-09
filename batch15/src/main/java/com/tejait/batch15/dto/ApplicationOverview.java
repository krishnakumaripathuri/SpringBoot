package com.tejait.batch15.dto;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationOverview {

    private int appId;
    private String companyName;
    private String city;
    private Long mobile;
    private String mail;
    private Long loanAmt;
    private int tenure;
    private String companyPan;
}


