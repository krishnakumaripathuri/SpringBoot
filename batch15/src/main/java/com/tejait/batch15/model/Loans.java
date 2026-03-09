package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="loan_application")
@Entity
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appId;
    private String fname;
    private String lname;
    private String customerName;
    private String mailId;
    private  Long   mobile;
    private String   city;

}
