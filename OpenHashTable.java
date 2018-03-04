/**********
  NAME: Shoaib Khan, Talha Sultan
 
  ICS4U0-A, Sep-Jan 2016
 
  THIS FILE IS PART OF THE PROGRAM: Employee Database Assignment (The "OpenHashTable" class), uses EmployeeInfo.java and it's subclasses. 
  Purpose: This class is used to set up and add attributes to the hash table.
 **********/
package employeedatabase;

import java.util.*;
import java.io.*;

public class OpenHashTable { //OpenHashTable class with attributes listed below

    public ArrayList<EmployeeInfo>[] buckets;

    //Creates a new arraylist per bucket in the hash table
    public OpenHashTable(int numBuckets) {
        buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList();
        }
    }
    
    //Adds the employee to the hashtable. (Uses the calcBucket method)
    public void addToTable(EmployeeInfo newEmp) {
        buckets[calcBucket(newEmp.getEmpNum())].add(newEmp);
    }

    //Takes an employee number input and checks if they exist. (Uses the calcBucket method)
    public int searchEmployee(int empNum) {
        for (int i = 0; i < buckets[calcBucket(empNum)].size(); i++) {
            if (buckets[calcBucket(empNum)].get(i).getEmpNum() == empNum) {
                return i;
            }
        }
        return -1;
    }

    //Takes an employee number input and removes them from the hashtable. (Uses the calcBucket method)
    public void removeEmployee(int empNum) {
        buckets[calcBucket(empNum)].remove(searchEmployee(empNum));
    }

    //Loads the contents of the text file (name given by user) into a hash table if the file exists. otherwise throws an IO exception. (Uses the addToTable method)
    public void loadDatabase(String companyName) throws IOException {
        StringTokenizer empTokenizer;
        EmployeeInfo newEmp;
        int empNum;
        String firstName;
        String lastName;
        String sex;
        String workLocation;
        double deductionRate;
        double annualSalary;
        double hourlyWage;
        int hoursPerWeek;
        int weeksPerYear;

        String fileName = companyName + ".txt";
        FileReader fileReader = new FileReader(fileName); // FileReader reads text files in the default encoding.
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            empTokenizer = new StringTokenizer(line, "|");

            empNum = Integer.parseInt(empTokenizer.nextToken());
            firstName = empTokenizer.nextToken();
            lastName = empTokenizer.nextToken();
            sex = empTokenizer.nextToken();
            workLocation = empTokenizer.nextToken();
            deductionRate = Double.parseDouble(empTokenizer.nextToken());
            if (empTokenizer.countTokens() == 1) {
                annualSalary = Double.parseDouble(empTokenizer.nextToken());
                newEmp = new FullTimeEmployee(empNum, firstName, lastName, sex, workLocation, deductionRate, annualSalary);
            } else {
                hourlyWage = Double.parseDouble(empTokenizer.nextToken());
                hoursPerWeek = Integer.parseInt(empTokenizer.nextToken());
                weeksPerYear = Integer.parseInt(empTokenizer.nextToken());
                newEmp = new PartTimeEmployee(empNum, firstName, lastName, sex, workLocation, deductionRate, hourlyWage, hoursPerWeek, weeksPerYear);
            }
            addToTable(newEmp);
        }
        scanner.close();
    }
    
    //Saves all the contents of the hash table into a text file named the compnay name given by the user.
    public void saveDatabase(String companyName) throws FileNotFoundException {

        PrintWriter file = new PrintWriter(companyName + ".txt");

        for (int i = 0; i < buckets.length; i++) {
            for (int a = 0; a < buckets[calcBucket(i)].size(); a++) {
                file.print(buckets[i].get(a).getEmpNum() + "|");
                file.print(buckets[i].get(a).getFirstName() + "|");
                file.print(buckets[i].get(a).getLastName() + "|");
                file.print(buckets[i].get(a).getSex() + "|");
                file.print(buckets[i].get(a).getWorkLocation() + "|");
                file.print(buckets[i].get(a).getDeductionRate() * 100 + "|");
                if (buckets[i].get(a) instanceof FullTimeEmployee) {
                    file.println(((FullTimeEmployee) buckets[i].get(a)).getAnnualSalary());
                } else {
                    file.print(((PartTimeEmployee) buckets[i].get(a)).getHourlyWage() + "|");
                    file.print(((PartTimeEmployee) buckets[i].get(a)).getHoursPerWeek() + "|");
                    file.println(((PartTimeEmployee) buckets[i].get(a)).getWeeksPerYear());
                }
            }
        }
        file.close();
    }

    //Takes the employee number input from a user and calculates which bucket it belongs in. Returns an intger (the bucket number).
    public int calcBucket(int empNum) {
        return (empNum % buckets.length);
    }
    
    //Error check (Checks if an input is of integer type)
    public static boolean isInteger(String textField) {
        try {
            Integer.parseInt(textField);
        } catch (NumberFormatException e) {
            return false;
        }
        // if exception isn't thrown, then it is an integer
        return true;
    }

    //Error check (Checks if an input is of a double type)
    public static boolean isDouble(String textField) {
        try {
            Double.parseDouble(textField);
        } catch (NumberFormatException e) {
            return false;
        }
        // if exception isn't thrown, then it is an integer
        return true;
    }
}
