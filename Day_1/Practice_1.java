package Day_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Practice_1 {
    public static void main(String[] args) {
        List<String> names = generateNames();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name to search:");
        String nameToSearch = scanner.nextLine();

        List<String> resultList = searchName(names, nameToSearch);
        printResults(resultList);
        scanner.close();
    }
    public static List<String> generateNames() {
        String[] dummy_names = {
            "Alice",
            "Bob",
            "Charlie",
            "Diana",
            "Ethan",
            "Fiona",
            "George",
            "Hannah",
            "Ivan",
            "Julia"
        };
        return new ArrayList<>(Arrays.asList(dummy_names));
    }
    public static List<String> searchName(List<String> names, String nameToSearch) {
        List<String> resultList = new ArrayList<>();
        nameToSearch = nameToSearch.toLowerCase();
        for (String name : names) {
            String nameLowercase = name.toLowerCase();
            if (nameLowercase.contains(nameToSearch)) {
                resultList.add(name);
            }
        }
        return resultList;
    }
    public static void printResults(List<String> results) {
        if (results.isEmpty()) {
            System.out.println("No names found.");
        } else {
            System.out.print("Output: ");
            for (int i = 0; i < results.size(); i++) {
                if(i==results.size()-1) {
                    System.out.print(results.get(i));
                } else {
                    System.out.print(results.get(i) + ", ");
                }
            }
        }
    }
}