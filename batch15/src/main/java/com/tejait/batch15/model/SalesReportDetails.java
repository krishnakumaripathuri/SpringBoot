package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_report")
public class SalesReportDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer appId;

    private String date;

    private String orderno;

    private String invoiceno;

    private String partyName;

    private String partyPhoneNum;

    private Double totalAmount;

    // Corrected spelling from 'recieved' to 'received'
    private Double recievedOrPaidAmount;

    private Double balanceAmount;
}

