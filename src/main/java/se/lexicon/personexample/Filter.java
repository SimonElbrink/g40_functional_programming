package se.lexicon.personexample;

@FunctionalInterface
public interface Filter<T> {

    boolean test(T t);
}
