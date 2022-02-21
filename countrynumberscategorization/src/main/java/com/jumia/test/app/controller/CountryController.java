package com.jumia.test.app.controller;

import com.jumia.test.app.constants.CountryConstants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
public class CountryController {

    @GetMapping("/countries")
    @CrossOrigin(origins = "http://localhost:8888")
    public List<String> getAllCountries() {
        return new ArrayList<>(CountryConstants.getCountryNamesMap().values());
    }
}
