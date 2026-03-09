package com.tejait.batch15.model;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "assurance_details")
// Example: If your JSON has "ename", your Java field must match
public class AssuranceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int appId;

   // @JsonProperty("ename") // This maps the JSON key "ename" to this field
    private String ename;

    private String nationality;
    private int age;
    private String mail;
    private String gender;

    // Getters and Setters are REQUIRED
}