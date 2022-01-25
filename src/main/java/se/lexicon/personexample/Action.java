package se.lexicon.personexample;

@FunctionalInterface
public interface Action<T> {

    void consume(T t);
}
