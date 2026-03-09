package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "addresses")
public class CompanyAddress {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int appId;
        private String flatNum;
        private String buildingName;
        private String line;
        private String area;
        private String city;
        private String state;
        private String landmark;
        private String pincode;

        // Getters and Setters

}
