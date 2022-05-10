package com.example.test.services;

import com.example.test.models.Country;
import com.example.test.repositories.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    public List<Country> getCountries() {
        return (List<Country>) countryRepo.findAll();
    }

    public Country createCountry(Country country) {
        countryRepo.save(country);
        return country;
    }

    public Country updateCountry(String countID, Country country) {
        Country country1 = countryRepo.findByCountryId(countID) ;
        if (country1 == null){
            return null;
        }

        country1.setCountryName(country.getCountryName());
        country1.setRegionId(country.getRegionId());
        countryRepo.save(country1);
        return country1;
    }

    public void deleteCountry(String countID) {
       countryRepo.deleteByCountryId(countID);
    }

    public Country getCountry(String countID) {

        return countryRepo.findByCountryId(countID);
    }


}
