package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long appId;

    private String transactionDate;

    private String activity;

    private String instrument;

    private String txnId;

    private String comment;

    private String debtAmt;

    private String creditAmt;

    private String transactionBreakup;

    private String transactionStatus;
}