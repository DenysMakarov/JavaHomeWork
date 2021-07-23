package controller;

import dao.Supermarket;
import models.Meat;
import models.Milk;
import models.Product;

public class SupermarketApp {

    public static void main(String[] args) {
        Supermarket mall = new Supermarket(10);

                                                    // создает либо новый продукт либо увеличивавет его количество на полках
        mall.addProduct(new Product("Bread", 2, 15, 668986581));
        mall.addProduct(new Product("Bread", 3, 15, 668986581));
        mall.addProduct(new Milk("Milk", 1, 8, 57842943, true, "11.11.2021", 23, 1.5, "Goat"));
        mall.addProduct(new Meat("Meat", 1, 67, 779875765, false, "17.08.2021", "Pig"));

        // в итоге Сыр бодет один но кол бодет 2
        mall.addProduct(new Milk("Cheese", 1, 12, 29842908, true, "15.11.2021", 33, 1.5, "Goat"));
        mall.addProduct(new Milk("Cheese", 1, 12, 29842908, true, "15.11.2021", 33, 1.5, "Goat"));

        mall.addProduct(new Meat("Meat", 3, 45, 779875756, false, "17.08.2021", "Pig"));
        mall.addProduct(new Meat("Meat", 2, 70, 55687432, false, "17.08.2021", 15, "Pig"));
        mall.addProduct(new Meat("Meat", 1, 54, 345875789, false, "17.08.2021", "Pig"));

//        mall.printAllProducts();                  // печатает все продукты
//        mall.printKosherProd();                   // печатает кошерные продукты
//        mall.printNotKosherProd();                // печатает не кошерные продукты
//        mall.removeProd(668986581);               // удаляет продукт либо уменьшает его количество на полках
//        double totalPrice = mall.totalPrice();    // сумма всех продуктов
//        mall.getSameTypeOfMilk("Goat");           // получить кошерные продукты
//        mall.getSameTypeOfMeat("Pig");            // получить некошерные продукты
        mall.printAllProducts();
    }
}
