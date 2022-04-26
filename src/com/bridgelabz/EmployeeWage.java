package com.bridgelabz;

import java.util.Random;

public class EmployeeWage {

    /*
     FULL_TIME,PART_TIME,MAX_WORKING_DAYS,WAGE_PER_HR,MAX_WORKING_HRS Are Declared
     Public Static Int for Use throughout Program.

     */
    public static final int FULL_TIME = 2;
    public static final int PART_TIME = 1;
    public static final int MAX_WORKING_DAYS = 20;
    public static final int WAGE_PER_HR = 20;
    public static final int MAX_WORKING_HRS = 100;
    /*
    Used the ComputeEmpWage() Method to Compute the Attendance, Calculate Daily Employee Wage,
    Wages for a Month,Refactor the Code.
     */
    public void ComputeEmpWage()
    {
        Random random = new Random();

        int totalWage = 0;
        int dailyWage;
        int workingHrs = 0;
        int day = 1, totalWorkingHrs = 0;

        for (day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS
                && totalWorkingHrs < MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int present = random.nextInt(3);
                /*
                Here we Used switch case for Attendance.
                 */

            switch (present) {
                case FULL_TIME -> {
                    workingHrs = 8;
                    System.out.println("Employee Working Fullday");
                }
                case PART_TIME -> {
                    workingHrs = 4;
                    System.out.println("Employee Working Part Time");
                }
                default -> {
                    workingHrs = 0;
                    System.out.println("Employee Absent");
                }
            }
            /*
            here we calculate the Daily Wages And Print them
             */
            dailyWage = workingHrs * WAGE_PER_HR;
            System.out.println("Day " + day + " workingHrs is " + workingHrs + " wage is: " + dailyWage);
            totalWage += dailyWage;
        }
        /*
        Printed the Total Wage.
         */
        System.out.println("Total wage for a month is " + totalWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome");
        /*
        Created The EmployeeWage Class Object and calling the ComputeEmpWage();
         */
        EmployeeWage ewc = new EmployeeWage();
        ewc.ComputeEmpWage();



    }
}

