package com.example.test.controllers;

import com.example.test.models.Region;
import com.example.test.services.RegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {
    @Autowired
    private RegionsService regionsService;

    @GetMapping
    public ResponseEntity<?> getRegions() {
        return new ResponseEntity<>(regionsService.getRegions(), HttpStatus.OK);
    }

    @GetMapping(path = "/{regionId}")
    public ResponseEntity<?> getRegion(@PathVariable Long regionId) {
        return new ResponseEntity<>(regionsService.getRegion(regionId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRegions(@RequestBody Region r) {
        return new ResponseEntity<>(regionsService.createRegions(r), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{regionId}")
    public ResponseEntity<?> updateRegions(@PathVariable Long regionId, @RequestBody Region r) {
        return new ResponseEntity<>(regionsService.updateRegions(regionId, r), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{regionId}")
    public ResponseEntity<?> deleteRegions(@PathVariable Long regionId) {
        regionsService.deleteRegions(regionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
