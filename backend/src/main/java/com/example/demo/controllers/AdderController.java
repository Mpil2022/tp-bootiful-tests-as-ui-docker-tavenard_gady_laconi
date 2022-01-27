package com.example.demo.controllers;

import com.example.demo.services.AdderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/adder", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AdderController {

    private AdderService adderService;

    public AdderController(AdderService adderService) {
        this.adderService = adderService;
    }

    @GetMapping("/current")
    public int currentNum() {
        return adderService.currentBase();
    }

    @PutMapping
    public int add(@RequestBody int num) {
        return adderService.accumulate(num);
    }

    @PostMapping
    public int addBaseNum(@RequestParam int num) {
        return adderService.baseNum(num);
    }

    @DeleteMapping
    public void delete(){
        adderService.baseNum(0);
    }
}