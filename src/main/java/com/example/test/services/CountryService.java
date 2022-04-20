package com.example.test.services;
import com.example.test.models.Country;
import com.example.test.models.Employee;
import com.example.test.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
   private CountryRepo countryRepo;

    public Iterable<Country> getCountries(){
        return countryRepo.findAll();
    }

    public Country createCountry(Country country) {
        return country;
    }

    public Country updateCountry(String COUNTRY_ID, Country country) {
        return country;
    }

    public void deleteCountry(String COUNTRY_ID) {}

    public Country getCountry(String COUNTRY_ID) {
        return null;
    }


}
