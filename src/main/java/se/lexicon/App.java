package se.lexicon;

/**
 * Hello world!
 *
 */
public class App 
{

    //Anonymous Class
    static DoStringStuff getBiggestString = new DoStringStuff(){

        @Override
        public String operate(String str1, String str2) {

            if (str1.length() >= str2.length()){
                return str1;
            }else{
                return str2;
            }
        }
    };

    public static String doStringStuff(String string1, String string2, DoStringStuff operator){
        return operator.operate(string1,string2);
    }

    public static void main( String[] args )
    {

        DoStringStuff concatenate = new StringOperator();

        String firstName = "Simon", lastName = "Elbrink";
        System.out.println(concatenate.operate(firstName, " " + lastName));




//        if ("ABC".length() >= "ABCD".length()){
//            System.out.println("ABC");
//        }else {
//            System.out.println("ABCD");
//        }


        //ReUsable
        System.out.println(getBiggestString.operate("ABC", "ABCD"));
        System.out.println(getBiggestString.operate("Susanne", "Helio"));


        //Using method with a functional Interface
        String stringStuff = doStringStuff(firstName, lastName, getBiggestString);
        System.out.println(stringStuff);


        String doStringStuff = doStringStuff(firstName, lastName, concatenate);

        //Anonymous Class on the fly.
        System.out.println(doStringStuff(firstName, lastName, new DoStringStuff() {
            @Override
            public String operate(String str1, String str2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str1 + " " + str2);
                stringBuilder.reverse();
                return stringBuilder.toString();
            }
        }));

    }

}
