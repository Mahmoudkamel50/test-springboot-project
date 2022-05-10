package com.example.test.repositories;

import com.example.test.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<Country, String> {
    Country findByCountryId(String id);
    void deleteByCountryId(String id);
}
