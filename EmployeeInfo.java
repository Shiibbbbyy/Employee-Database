/***********
 NAME: Shoaib Khan, Talha Sultan
 
 ICS4U0-A, Sep-Jan 2016

 THIS FILE IS PART OF THE PROGRAM: Employee Database Assignment (The "EmployeeInfo" class)
 Purpose: This class is used to set up and add attributes to the EmployeeInfo Object.

 **********/
package employeedatabase;

public class EmployeeInfo{
        private int empNum;
        private String firstName;
        private String lastName;
        private String sex;
        private String workLocation;
        private double deductionRate;
        
        // Constructor to set up order of inputs.
        public EmployeeInfo (int empNum, String firstName, String lastName, String sex, String workLocation, double deductionRate){
                this.empNum = empNum;
                this.firstName = firstName;
                this.lastName = lastName;
                this.sex = sex;
                this.workLocation = workLocation;
                this.deductionRate = deductionRate;
        }

        public int getEmpNum (){
                return empNum;
        }

        public void setEmpNum (int empNum){
                this.empNum = empNum;
        }

        public String getFirstName (){
                return firstName;
        }

        public void setFirstName (String firstName){
                this.firstName = firstName;
        }

        public String getLastName (){
                return lastName;
        }

        public void setLastName (String lastName){
                this.lastName = lastName;
        }

        public String getSex (){
                return sex;
        }

        public void setSex (String sex){
                this.sex = sex;
        }

        public String getWorkLocation (){
                return workLocation;
        }

        public void setWorkLocation (String workLocation){
                this.workLocation = workLocation;
        }

        public double getDeductionRate(){
                return deductionRate/100;
        }

        public void setDeductionRate (double deductionRate){
                this.deductionRate = deductionRate;
        }
}
