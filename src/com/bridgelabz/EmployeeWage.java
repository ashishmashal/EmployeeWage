package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;


interface IEmployeeWageComputation
{
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    public void calculateTotalWage();

    public int getTotalEmpWage(String companyName);
}

class CompanyEmpWage
{
    // instance constants
    final String COMPANY_NAME;
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;
    // instance variable
    int totalEmpWage;

    //parameterized constructor to get and set the values
    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalEmpWage = 0;
    }

    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }

    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalEmpWage + "\n";
    }
}
public class EmployeeWage implements IEmployeeWageComputation
{
    // class constants
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    // instance variables
    ArrayList<CompanyEmpWage> companies;
    HashMap<String,Integer> totalEMPWage;

    //default constructor
    public EmployeeWage()
    {
       companies = new ArrayList<>();
        totalEMPWage = new HashMap<>();
    }

    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        /*
        Adding All Company Wages In HashMAps
        using totalEMPWage.put(companyName,0);

         */
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
        totalEMPWage.put(companyName,0);
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
        for (CompanyEmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage)
    {
        System.out.println("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        //Calculating hashmaps Total Emp Wages
        totalEMPWage.put(companyEmpWage.COMPANY_NAME,totalWage);
        return totalWage;
    }
    //Printing This All Company and Their total Employee Wages.
    public int getTotalEmpWage(String companyName)
    {
        return totalEMPWage.get(companyName);
    }
    public static void main(String[] args)
    {
        EmployeeWage employeewaagecomputation = new EmployeeWage();
        employeewaagecomputation.addCompany("Microsoft", 4, 30, 100);
        employeewaagecomputation.addCompany("Google", 5, 40, 170);
        employeewaagecomputation.addCompany("Apple", 9, 10, 70);
        employeewaagecomputation.calculateTotalWage();
        String query = "Microsoft";
        int totalWage = employeewaagecomputation.getTotalEmpWage(query);
        System.out.println("Total Employee Wage for " + query + " company is " + totalWage);
    }
}

