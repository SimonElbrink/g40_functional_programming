package se.lexicon;

public class StringOperator implements DoStringStuff{

    @Override
    public String operate(String str1, String str2) {
        return str1.concat(str2);
    }
}
