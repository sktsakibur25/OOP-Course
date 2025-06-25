package Day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice_3 {
    public static void main(String[] args) {
        List<List<String>> groceryPriceList = groceryPriceList();
        
        System.out.println("Grocery Items:"+ groceryPriceList);
    }

    private static List<List<String>> groceryPriceList() {
        List<List<String>> groceryPriceList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./Day_1/groceryitems.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().replaceAll("\\s+", ",");
                String[] values = line.split(",");
                groceryPriceList.add(Arrays.asList(values));
            }
            return groceryPriceList;
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }


}
