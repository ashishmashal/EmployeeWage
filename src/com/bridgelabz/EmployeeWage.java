package com.bridgelabz;

import java.util.Random;

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome");

        Random random = new Random();
        int present = random.nextInt(2);
        //Check if employee is present
        if (present == 1)
            System.out.println("Employee is present.");
        else
            System.out.println("Employee is absent.");
    }
}
