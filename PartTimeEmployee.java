/**********
  NAME: Shoaib Khan
 
  ICS4U0-A, Sep-Jan 2016
 
  THIS FILE IS PART OF THE PROGRAM: Employee Database Assignment (The "PartTimeEmployee" class)
  Purpose: This class is used to set up and add attributes to the subclass of the EmployeeInfo Object (PartTimeEmployee).
 **********/
package employeedatabase;

public class PartTimeEmployee extends EmployeeInfo{
        private double hourlyWage;
        private int hoursPerWeek;
        private int weeksPerYear;

        //Below is the part time employee subattributes and submethods being combined with the attributes and methods of the employeeinfo class.
        public PartTimeEmployee(int empNum, String firstName, String lastName, String sex, String workLocation, double deductionRate, double hourlyWage, int hoursPerWeek, int weeksPerYear) {
                super(empNum, firstName, lastName, sex, workLocation, deductionRate);
                this.hourlyWage = hourlyWage;
                this.hoursPerWeek = hoursPerWeek;
                this.weeksPerYear = weeksPerYear;
        }

        public double getHourlyWage(){
                return hourlyWage;
        }

        public void setHourlyWage (double hourlyWage){
                this.hourlyWage = hourlyWage;
        }

        public int getHoursPerWeek(){
                return hoursPerWeek;
        }

        public void setHoursPerWeek (int hoursPerWeek){
                this.hoursPerWeek = hoursPerWeek;
        }

        public int getWeeksPerYear(){
                return weeksPerYear;
        }

        public void setWeeksPerYear (int weeksPerYear){
                this.weeksPerYear = weeksPerYear;
        }

        public double calcAnnualGrossSalary (double hourlyWage, int hoursPerWeek, int weeksPerYear, double deductionRate){
                return (hourlyWage*hoursPerWeek*weeksPerYear) - (hourlyWage*hoursPerWeek*weeksPerYear*deductionRate);
        }  
}
