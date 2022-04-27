package com.bridgelabz;

import java.util.Random;

public class EmployeeWage {

    /*
     FULL_TIME,PART_TIME,MAX_WORKING_DAYS,WAGE_PER_HR,MAX_WORKING_HRS Are Declared
     Public Static Int for Use throughout Program.
     */
    public static final int FULL_TIME = 2;
    public static final int PART_TIME = 1;
    public static int MAX_WORKING_DAYS = 20;
    public static  String COMPANY_NAME;
    public static int WAGE_PER_HR = 20;
    public static int MAX_WORKING_HRS = 100;

    int totalWage;

    /*
    Used the ComputeEmpWage() Method to Compute the Attendance, Calculate Daily Employee Wage,
    Wages for a Month,Refactor the Code.
     */
    EmployeeWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalWage = 0;
    }

    int generateEmployeeType()
    {
        return (int) (Math.random() * 100) % 3;
    }
    int getWorkingHrs(int empType)
    {
        return switch (empType) {
            case FULL_TIME -> 8;
            case PART_TIME -> 4;
            default -> 0;
        };
    }

    public void calculateTotalWage()
    {
        System.out.println("Computation of total wage of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");
        int workingHrs;
        for (int day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS
                && totalWorkingHrs <= MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * WAGE_PER_HR;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }

    }

    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalWage + "\n";
    }

    public static void main(String[] args) {
        System.out.println("Welcome");
        /*
        Created The EmployeeWage Class Object and calling the ComputeEmpWage();
         */
        EmployeeWage amazon = new EmployeeWage("Amazon", 40, 15, 200 );

        //calculateTotalWage Using object amazon
        amazon.calculateTotalWage();
        System.out.println(amazon);

        EmployeeWage ibm = new EmployeeWage("IBM", 20, 20, 100);

        //calculateTotalWage Using object ibm
        ibm.calculateTotalWage();
        System.out.println(ibm);
    }
}

