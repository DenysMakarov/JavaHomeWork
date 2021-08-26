package dao;

import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Supermarket implements ISuperMarket{

    Collection<Product> productCollection ;

    public Supermarket() {
        productCollection = new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (productCollection.contains(product)) return false;
        productCollection.add(product);
        return true;
    }

    @Override
    public Product removeProduct(long barCode) {
        Product p = findByBarCode(barCode);
        if (p != null) productCollection.remove(p);
        return p;
    }


    @Override
    public Product findByBarCode(long barCode) {
        for (Product p : productCollection){
            if (p.getBarCode() == barCode) return p;
        }
        return null;
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        Collection<Product> temp = new ArrayList<>();
        for (Product p : productCollection) {
            if (p.getCategory().equals(category)) temp.add(p);
        }
        return temp;
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        Collection<Product> temp = new ArrayList<>();
        for (Product p : productCollection) {
            if (p.getBrand().equals(brand)) temp.add(p);
        }
        return temp;
    }

    @Override
    public Iterable<Product> findProductWithExpDate() {
        Collection<Product> temp = new ArrayList<>();
        for (Product p : productCollection) {
            if (p.getExpDate().isBefore(LocalDate.now())) temp.add(p);
        }
        return temp;
    }

    @Override
    public int skuQuantity() {
        return productCollection.size();
    }

    @Override
    public Iterator<Product> iterator() {
        return productCollection.iterator();
    }

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        supermarket.addProduct(new Product(1000, "Milk", "drink", "TacoBell", 15.0, LocalDate.of(2021, 5, 12)));
        supermarket.addProduct(new Product(2000, "Chicken", "food", "TacoBell", 27.0, LocalDate.of(2022, 04, 12)));
        supermarket.addProduct(new Product(3000, "juice", "drink", "McDonald’s", 11.0, LocalDate.of(2021, 11, 12)));
        supermarket.addProduct(new Product(4000, "Cow", "food", "McDonald’s", 34.0, LocalDate.of(2022, 11, 12)));
        supermarket.addProduct(new Product(4000, "Cow", "food", "McDonald’s", 34.0, LocalDate.of(2022, 11, 12)));
        supermarket.addProduct(new Product(5000, "Beer", "drink", "TacoBell", 57.0, LocalDate.of(2021, 7, 12)));
        supermarket.addProduct(new Product(6000, "Fish", "food", "McDonald’s", 23.0, LocalDate.of(2022, 3, 12)));

        System.out.println(" ------- allProducts -------");
        for (Product p : supermarket) { System.out.println(p); }

//        System.out.println("BarCode : " + supermarket.findByBarCode(3000)); // find
//        supermarket.removeProduct(3000); // remove
//        supermarket.removeProduct(7000); // null
//
//        System.out.println(" ------- findProductWithExpDat -------");
//        for (Product p : supermarket.findProductWithExpDate()) { System.out.println(p); }
//
//        System.out.println(" ------- findByCategory -------");
//        for (Product p : supermarket.findByCategory("drink")) { System.out.println(p); }
//
//        System.out.println(" ------- findByBrand -------");
//        for (Product p : supermarket.findByBrand("TacoBell")) { System.out.println(p); }

    }
}
