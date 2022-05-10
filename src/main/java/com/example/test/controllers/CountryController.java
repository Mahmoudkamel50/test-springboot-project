package com.example.test.controllers;

import com.example.test.models.Country;
import com.example.test.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getCountries(){

        return new ResponseEntity<>( countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping(path = "/{countryId}")
    public ResponseEntity<?> getCountry(@PathVariable String countryId){
        return new ResponseEntity<>( countryService.getCountry(countryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody Country country){
        return new ResponseEntity<> (countryService.createCountry(country) , HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{countryId}")
    public ResponseEntity<?> updateCountry(@PathVariable String countryId, @RequestBody Country country){
        return new ResponseEntity<> (countryService.updateCountry(countryId, country) , HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{countryId}")
    public  ResponseEntity<?> deleteCountry(@PathVariable String countryId){
        countryService.deleteCountry(countryId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
