package com.company;

import java.util.Scanner;

/**
 * @author Taras Maslyuk
 */
public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        int maxWeightBox = 330, maxPriceBox = 500;
        PresentBox box = new PresentBox();
        box.add(new Candy("Red Hot Chille Pappers", 50, 80, "Sour"));
        box.add(new Jellybean("Pit", 40, 90, "Apple Juce"));
        box.add(new Marmalade("Justice", 50, 100, "Bears"));
        box.add(new Chocolate("AlpenGold", 100, 200, "Dark"));
        box.add(new Cookies("Dark Side", 100, 50, "Oat"));
        System.out.println("Your purchase:");
        System.out.println("Total weight - " + box.countWeight() + " Total price - " + box.countPrice() + " ;");
        box.writeInfo();
        System.out.println("Delete last? Yes - 1 ; No - 2");
        choice = scan.nextInt();
        if (choice == 1) {
            box.deleteLast();
        }
        box.reducePrice(maxPriceBox);
        box.reduceWeight(maxWeightBox);
        System.out.println("Thank you,Bay.");
    }
}