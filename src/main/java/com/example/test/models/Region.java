package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGIONS",schema = "HR")
public class Region {
    @Id
    @Column(name = "REGION_ID")
    private Long regionId;
    @Column(name = "REGION_NAME")
    private String regionName;
}
