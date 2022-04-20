package com.example.test.models;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "countries", schema ="hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {

    private static final long serialVersionUID = -4980000870833877764L;

    @Id
    private String COUNTRY_ID;
    private String COUNTRY_NAME;
    private Integer REGION_ID;


}
