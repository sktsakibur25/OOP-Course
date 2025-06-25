package Day_1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Practice_2 {
    public static void main(String[] args) {
        Integer minSalary = Integer.MAX_VALUE;
        Integer maxSalary = Integer.MIN_VALUE;
        String minSalaryName = "";
        String maxSalaryName = "";

        try (BufferedReader br = new BufferedReader(new FileReader("./Day_1/salarysheet.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    String name = values[0].trim();
                    try {
                        Integer salary = Integer.parseInt(values[1].trim());
                        if (salary < minSalary) {
                            minSalary = salary;
                            minSalaryName = name;
                        }
                        if (salary > maxSalary) {
                            maxSalary = salary;
                            maxSalaryName = name;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format for " + name + ": " + values[1]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        printSalaryDetails(minSalaryName, minSalary, maxSalaryName, maxSalary);

    }

    private static void printSalaryDetails(String minSalaryName, Integer minSalary,
                                           String maxSalaryName, Integer maxSalary) {
        if(maxSalaryName.length() > minSalaryName.length() ){
           Integer spaceCount = maxSalaryName.length() - minSalaryName.length();
           for(int i = 0; i < spaceCount; i++) {
               minSalaryName += " ";
           }
        }else{
              Integer spaceCount = minSalaryName.length() - maxSalaryName.length();
              for(int i = 0; i < spaceCount; i++) {
                maxSalaryName += " ";
              }
        }
        System.out.println("Max: " + maxSalaryName + "  " + maxSalary);
        System.out.println("Min: " + minSalaryName + "  " + minSalary);
    }
}
