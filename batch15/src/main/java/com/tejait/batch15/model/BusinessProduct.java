package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="business_products")
@Entity
public class BusinessProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int appId;
    private String purposeOfLoan;
    private String natureOfBusiness;
    private int tenure;
    private Long loanAmount;

}
