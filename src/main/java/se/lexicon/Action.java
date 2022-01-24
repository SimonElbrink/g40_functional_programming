package se.lexicon;

@FunctionalInterface
public interface Action<T> {

    void consume(T t);
}
