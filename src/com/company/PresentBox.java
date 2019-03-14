package com.company;

import java.util.Arrays;

/**
 * @author Taras Maslyuk
 */
public class PresentBox implements Box {
    public Sweets[] sweet = new Sweets[0];
    static int numberOfSweet = 0;

    /**
     * @author Taras Maslyuk
     * Adds item to the new year's gift
     */
    @Override
    public void add(Sweets sweet) {
        Sweets[] buff = Arrays.copyOf(this.sweet, this.sweet.length + 1);
        buff[numberOfSweet] = sweet;
        this.sweet = Arrays.copyOf(buff, buff.length);
        numberOfSweet++;
    }

    /**
     * @author Taras Maslyuk
     * Removes the last of the New Year's gift
     */
    @Override
    public void deleteLast() {
        try {
            Sweets[] buff = Arrays.copyOf(sweet, sweet.length);
            this.sweet = Arrays.copyOf(buff, buff.length - 1);
            System.out.println("");
            System.out.println("You remove last sweetness!");
            numberOfSweet -= 1;
        } catch (NullPointerException e) {
            System.out.println("Error!");
        }
        System.out.println("Your purchase now:");
        this.writeInfo();
    }

    /**
     * @param index the sweet number wants to delete
     * @author Taras Maslyuk
     */
    @Override
    public void deleteInd(int index) {
        Sweets[] buff = Arrays.copyOf(this.sweet, this.sweet.length);
        int j = 0;
        for (int i = 0; i <= sweet.length - 1; i++) {
            if (i != index) {
                buff[j] = this.sweet[i];
                j++;
            } else {
                continue;
            }
        }
        sweet = Arrays.copyOf(buff, buff.length - 1);
        numberOfSweet--;
    }

    /**
     * @author Taras Maslyuk
     * Counts the total weight of the New Year's gift
     */
    @Override
    public int countWeight() {
        try {
            int weight = 0;
            for (int i = 0; i <= numberOfSweet - 1; i++) {
                weight += this.sweet[i].weight;
            }
            return weight;
        } catch (NullPointerException e) {
            System.out.println("Error!");
            return 0;
        }
    }

    /**
     * @author Taras Maslyuk
     * Counts the total price of the New Year's gift
     */
    @Override
    public int countPrice() {
        try {
            int price = 0;
            for (int i = 0; i <= numberOfSweet - 1; i++) {
                price += this.sweet[i].price;
            }
            return price;
        } catch (NullPointerException e) {
            System.out.println("Error!");
            return 0;
        }
    }

    /**
     * @author Taras Maslyuk
     * Displays full information about the New Year's gift
     */
    @Override
    public void writeInfo() {
        try {
            for (int i = 0; i <= numberOfSweet - 1; i++) {
                System.out.println("# " + (i + 1) + " Name - " + this.sweet[i].name + "   Weight - " + this.sweet[i].weight + "   Price - " + this.sweet[i].price + " Uniq - " + this.sweet[i].uniq);
            }
        } catch (NullPointerException e) {
            System.out.println("Error!");
        }
    }

    /**
     * @author Taras Maslyuk
     * Corrects the weight of the New Year's gift
     */
    public void reduceWeight(int maxW) {
        try {
            if (this.countWeight() != 0) {
                while (this.countWeight() > maxW) {
                    System.out.println("The gift is worth more than the maximum amount of purchase! We removed the cheapest item.");
                    int[] weight = new int[this.sweet.length];
                    for (int i = 0; i <= numberOfSweet - 1; i++) {
                        weight[i] = this.sweet[i].weight;
                    }
                    deleteInd(minInd(weight));
                    System.out.println("New Year's gift is ready:");
                    this.writeInfo();
                }

            } else System.out.println("Gift is empty!");
        } catch (NullPointerException e) {
            System.out.println("Error!");
        }
    }

    /**
     * @author Taras Maslyuk
     * Corrects the price of the New Year's gift
     */
    public void reducePrice(int maxP) {
        try {
            if (this.countWeight() > 0) {
                while (this.countPrice() > maxP) {
                    System.out.println("The gift is worth more than the maximum weight of purchase! We removed the lightest item.");
                    int[] price = new int[this.sweet.length];
                    for (int i = 0; i <= numberOfSweet - 1; i++) {
                        price[i] = this.sweet[i].price;
                    }
                    deleteInd(minInd(price));
                    System.out.println("New Year's gift is ready:");
                    this.writeInfo();
                }

            } else System.out.println("Gift is empty!");
        } catch (NullPointerException e) {
            System.out.println("Error!");
        }
    }

    /**
     * @author Taras Maslyuk
     * Searches for the index of the smallest item
     */
    public static int minInd(int[] array) {
        int indexMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[indexMin])
                indexMin = i;
        }
        return indexMin;
    }

}
