package com.example;

public class BmiCalculator {

    public double calculateBMI(double weight, double height) {

        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Weight and height must be positive");
        }

        if (weight > 500 || height < 0.5 || height > 3.0) {
            throw new IllegalArgumentException("Invalid input values");
        }

        return weight / (height * height);
    }

    public String getCategory(double bmi) {

        if (bmi < 0) {
            throw new IllegalArgumentException("Invalid BMI");
        }

        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }
}