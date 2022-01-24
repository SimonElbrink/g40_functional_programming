package se.lexicon;

@FunctionalInterface
public interface Filter<T> {

    boolean test(T t);
}
