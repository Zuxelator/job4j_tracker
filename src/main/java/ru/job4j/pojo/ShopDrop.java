package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        if (index != products.length - 1) {
            for (int i = index; i < products.length; i++) {
                products[index] = products[index + 1];
            }
        }
        products[products.length - 1] = null;
        return products;
    }
}
