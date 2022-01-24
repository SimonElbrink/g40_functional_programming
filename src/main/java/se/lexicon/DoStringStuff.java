package se.lexicon;

@FunctionalInterface
public interface DoStringStuff {

    //ONE Abstract Method Only.
    //Any Number of Default/static methods are allowed.

    String operate(String str1, String str2);

}
