package com.bridgelabz;

import java.util.Random;

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome");

        Random random = new Random();
        int present = random.nextInt(3);
        //Check if employee is present
        int WagePerHr = 20;
        int dailyWage, workingHrs;
        if (present == 0) {
            //Employee is absent
            workingHrs = 0;
            System.out.println("Employee is absent");
        } else if (present == 1) {
            //Employee working as part-time
            workingHrs = 8;
            System.out.println("Employee working as part-time");
        } else {
            //Employee working as full time
            workingHrs = 16;
            System.out.println("Employee working as full time");
        }
        dailyWage = workingHrs * WagePerHr;
        System.out.println("Daily wage is " + dailyWage);


    }
}
