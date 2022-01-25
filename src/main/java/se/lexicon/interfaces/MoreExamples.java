package se.lexicon.interfaces;

import se.lexicon.interfaces.Calculator;
import se.lexicon.interfaces.Conditional;
import se.lexicon.interfaces.IntRandomGen;
import se.lexicon.interfaces.Printer;

import java.util.concurrent.ThreadLocalRandom;

public class MoreExamples {


    //Included Type
    static Printer printer = (String str1) -> System.out.println(str1);

    //Excluded Type
    static Conditional positive = (intValue) -> intValue > 0;
    // Excluded Type + no ().
    static Conditional negative = intValue -> intValue < 0;

    //When Empty need ()
    static IntRandomGen rng = () -> ThreadLocalRandom.current().nextInt();


    //Multi statement have Return and body {}
    static Calculator calculator = (d1, d2, operator) ->
    {
        switch (operator){
            case "+":
                return d1 + d2;
            case "-":
                return d1 - d2;
            case "/":
                return d1 / d2;
            case "*":
                return d1 * d2;
            default:
                return 0;
        }
    };



    public static void main(String[] args) {


        printer.print("Hello World");

        boolean isPositive = positive.test(100);
        printer.print(Boolean.toString(isPositive));

        System.out.println(rng.generate());

        System.out.println(calculator.calculate(200, 300, "*"));

    }
}
