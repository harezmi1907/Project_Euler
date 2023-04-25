package Java_Buchalka;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class lists {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add item(s) seperated by a comma:");
        String[] items = scanner.nextLine().split(",");
        for (String item: items) {
            String trimmed = item.trim();
            if(groceries.indexOf(trimmed) < 0) {
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Remove item(s) seperated by a comma:");
        String[] items = scanner.nextLine().split(",");
        for (String item: items) {
            String trimmed = item.trim();
            if(groceries.indexOf(trimmed) > 0) {
                groceries.remove(trimmed);
            }
        }
    }

    private static void printActions() {
        String textBlock = """
    Available Actions:
    0: shutdown
    1: add items
    2: remove items
    Enter a number for your action: """;
        System.out.println(textBlock);
    }

}
