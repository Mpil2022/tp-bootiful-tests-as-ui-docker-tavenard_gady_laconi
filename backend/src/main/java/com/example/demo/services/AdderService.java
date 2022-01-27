package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class AdderService {

    private int num;

    public int baseNum(int base) {
        this.num = base;
        return num;
    }

    public int currentBase() {
        return num;
    }

    public int add(int adder) {
        return this.num + adder;
    }

    public int accumulate(int adder) {
        return this.num += adder;
    }
}