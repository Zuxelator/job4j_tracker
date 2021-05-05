package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int res = -1;
        for (int index = 0; index < products.length; index++) {
            if (products[index] == null) {
                res = index;
                break;
            }
        }
        return res;
    }
}
