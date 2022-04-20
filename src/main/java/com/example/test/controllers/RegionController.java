package com.example.test.controllers;
import com.example.test.models.Regions;
import com.example.test.services.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionsService regionsService;
    @GetMapping
    public ResponseEntity<?> getRegions(){
        return new ResponseEntity<>(regionsService.getRegions(), HttpStatus.OK);
    }

    @GetMapping("/{REGION_ID}")
    public ResponseEntity<?> getRegion(Integer REGION_ID){
        return new ResponseEntity<>(regionsService.getRegion(REGION_ID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRegions (@RequestBody Regions r){
        return new ResponseEntity<>(regionsService.createRegions(r) , HttpStatus.CREATED);
    }

    @PutMapping("/{REGION_ID}")
    public ResponseEntity<?> updateRegions(@PathVariable Integer REGION_ID,@RequestBody Regions r){
        return new ResponseEntity<>(regionsService.updateRegions(REGION_ID,r), HttpStatus.OK);
    }

    @DeleteMapping("/{REGION_ID}")
    public ResponseEntity<?> deleteRegions(@PathVariable Integer REGION_ID){
        regionsService.deleteRegions(REGION_ID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
