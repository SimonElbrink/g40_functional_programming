package se.lexicon.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductPractice {

    static List<Product> products = new ArrayList<>(Arrays.asList(

            new Product("Amelia", 15, 50),
            new Product("Amarylic", 12, 30),
            new Product("Findus", 10, 4),
            new Product("Signe", 9, 0),
            new Product("Spots", 5, 3)

    ));

    public static void main(String[] args) {
//        //AIC
//        Action printOut = new Action() {
//            @Override
//            public void execute(Product product) {
//                System.out.println(product);
//            }
//        };


        System.out.println("OUT OF STOCK");
        //Lambda
        Action printOut = (product) -> System.out.println(product);
        Conditional outOfStock = product -> product.getStock() == 0;
        findAndDo(products, outOfStock, printOut);


        System.out.println("PRODUCTS STARTS WITH A");
        Conditional startWithF = product -> product.getProductName().startsWith("A");
        findAndDo(products, startWithF, printOut);


        System.out.println("PRICE BETWEEN 10-15");
        findAndDo(
                products,
                product -> product.getPrice() >= 10 && product.getPrice() <= 15,
                printOut
        );

        System.out.println("PRICE INCREASE");
        findAndDo(
                products,
                product -> product.getStock() < 10 && product.getStock() > 0,
                product -> product.setPrice(product.getPrice() * 1.5 )
        );

        products.forEach(System.out::println);

    }

    public static void findAndDo(List<Product> products, Conditional conditional, Action action){
        for (Product p : products) {
            if (conditional.test(p)){
                action.execute(p);
            }
        }
    }
}
