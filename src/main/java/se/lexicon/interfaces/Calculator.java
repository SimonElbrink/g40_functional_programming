package se.lexicon.interfaces;

@FunctionalInterface
public interface Calculator {

    double calculate(double number1, double number2, String operator);
}
