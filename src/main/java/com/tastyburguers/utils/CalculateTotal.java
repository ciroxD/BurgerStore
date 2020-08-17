package com.tastyburguers.utils;

import java.util.List;

public class CalculateTotal {

    public double finalPrice(List<Double> price) {
        double sum = 0;
        for (double i: price) {
            sum += i;
        }
        return sum;
    }
}