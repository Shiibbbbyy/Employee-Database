/** *********
 * NAME: Shoaib Khan, Talha Sultan
 *
 * ICS4U0-A, Sep-Jan 2016
 *
 * THIS FILE IS PART OF THE PROGRAM: Employee Database Assignment (The "FullTimeEmployee" class)
 * Purpose: This class is used to set up and add attributes to the subclass of the EmployeeInfo Object (FullTimeEmployee).
 ********* */
package employeedatabase;

public class FullTimeEmployee extends EmployeeInfo {

    private double annualSalary;

    //Below is the full time employee subattributes and submethods being combined with the attributes and methods of the employeeinfo class.
    public FullTimeEmployee(int empNum, String firstName, String lastName, String sex, String workLocation, double deductionRate, double annualSalary) {
        super(empNum, firstName, lastName, sex, workLocation, deductionRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double calcAnnualGrossSalary(double annualSalary, double deductionRate) {
        return annualSalary - (annualSalary * deductionRate);
    }
}
