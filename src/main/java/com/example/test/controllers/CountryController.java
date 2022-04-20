package com.example.test.controllers;

import com.example.test.models.Country;
import com.example.test.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping
    public ResponseEntity<?> getCountries(){

        return new ResponseEntity<>( countryService.getCountries(), HttpStatus.OK);
    }


    @GetMapping("/{COUNTRY_ID}")
    public ResponseEntity<?> getCountry(String COUNTRY_ID){

        return new ResponseEntity<>( countryService.getCountry(COUNTRY_ID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody Country country){
        return new ResponseEntity<> (countryService.createCountry(country) , HttpStatus.CREATED);
    }

    @PutMapping("/{COUNTRY_ID}")
    public ResponseEntity<?> updateCountry(@PathVariable String COUNTRY_ID, @RequestBody Country country){
        return new ResponseEntity<> (countryService.updateCountry(COUNTRY_ID, country) , HttpStatus.OK);
    }

    @DeleteMapping("/{COUNTRY_ID}")
    public  ResponseEntity<?> deleteCountry(@PathVariable String COUNTRY_ID){
        countryService.deleteCountry(COUNTRY_ID);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
