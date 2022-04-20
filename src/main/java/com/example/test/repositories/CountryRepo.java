package com.example.test.repositories;

import com.example.test.models.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepo extends CrudRepository<Country, String> {

    Country findByCOUNTRY_ID (Integer COUNTRY_ID);
    List<Country> findAllBy();



}
