package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "regions", schema ="hr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regions implements Serializable {
    private static final long serialVersionUID = -4273930867586517794L;
    @Id
    private Integer REGION_ID;
    private String REGION_NAME;
}
