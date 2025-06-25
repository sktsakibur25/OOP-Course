package Day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Practice_3 {
    public static void main(String[] args) {
        final double VAT = 5.0; // in %

        HashMap<String, List<Double>> groceryItems = readGroceryPriceList();

        Double totalPrice = calculateTotalPrice(groceryItems);

        printVoucher(groceryItems, totalPrice, VAT);
    }

    private static Double calculateTotalPrice(HashMap<String, List<Double>> groceryItems) {
        Set<String> itemIds = groceryItems.keySet();
        Double totalPrice = 0.0;
        for (String id : itemIds) {
            List<Double> itemRow = groceryItems.get(id);
            Double itemTotalPrice = itemRow.get(0) * itemRow.get(1);
            itemRow.set(2, itemTotalPrice);
            groceryItems.put(id, itemRow);
            totalPrice += itemTotalPrice;
        }
        return totalPrice;
    }

    private static HashMap<String, List<Double>> readGroceryPriceList() {
        HashMap<String, List<Double>> groceryItems = new HashMap<String, List<Double>>();

        try (BufferedReader br = new BufferedReader(new FileReader("./Day_1/groceryitems.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().replaceAll("\\s+", ",");
                String[] items = line.split(",");
                if (items.length > 1) {
                    if (groceryItems.containsKey(items[0])) {
                        throw new Exception("Duplicate Item Id " + items[0] + " found");
                    } else {
                        Double[] itemPriceArray = { Double.parseDouble(items[1]), Double.parseDouble(items[2]), 0.0};
                        List<Double> itemPrice = Arrays.asList(itemPriceArray);
                        groceryItems.put(items[0], itemPrice);
                    }
                }
            }
            return groceryItems;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    private static void printVoucher(HashMap<String, List<Double>> groceryItems,
                                     Double totalPrice, Double VAT){
        String space = " ";
        Integer count = 15;
        Integer quantity = 0;
        System.out.printf("%s        %s          %s     %s", "Item Id", "Qty", "unit price", "total\n");
        Set<String> itemIdSet = groceryItems.keySet();
        for (String Id : itemIdSet) {
            List<Double> itemRow = groceryItems.get(Id);
            quantity = quantity + itemRow.get(0).intValue();
            System.out.printf("%s%s%.0f%s%.1f%s%.2f%n", Id, space.repeat(count-Id.length()), itemRow.get(0), space.repeat(count-((""+itemRow.get(0)).length())), itemRow.get(1), space.repeat(count-(""+itemRow.get(1)).length()), itemRow.get(2));
        }
        System.out.println();
        System.out.printf("%s%s%d%s%s%s%.2f%n",
         "total",
        space.repeat(count-"total".length()),
        quantity,
        space.repeat(count-(("  "+quantity).length())),
        "Grand Total",
        space.repeat(count-("Grand Total".length())),
        totalPrice);
        Double total_vat = totalPrice * ((VAT*1.0)/100);
        System.out.printf("%s%s%s%.2f%n",space.repeat(28), "VAT("+VAT.intValue()+"%)",space.repeat(8),
        total_vat);
        System.out.printf("%s%s%s%.2f%n",space.repeat(28), "Net total",space.repeat(6),
        totalPrice+total_vat);
        System.out.printf("%s%s%s%.2f%n",space.repeat(28), "Round Off",space.repeat(6),
        Math.ceil(totalPrice+total_vat)-(totalPrice+total_vat));
        System.out.printf("%s%s%s%.2f%n",space.repeat(28), "Total Payable",space.repeat(2),
        Math.ceil(totalPrice+total_vat));
    }
}
