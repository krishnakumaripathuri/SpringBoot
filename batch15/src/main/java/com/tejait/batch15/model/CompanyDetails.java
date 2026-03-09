package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Table(name = "company_details")
@Entity
public class CompanyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int appId;
    private String companyName;
    private String dateOfEstablish;
    private String gstin;
    private String companyPan;
    private String industryType;
    private Long turnover;


}
