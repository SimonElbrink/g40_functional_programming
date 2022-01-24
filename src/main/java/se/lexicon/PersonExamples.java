package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PersonExamples {


    static List<Person> people = new ArrayList<>(Arrays.asList(
            new Person(1, "Simon", "Elbrink", LocalDate.parse("1997-03-18")),
            new Person(2, "Antonie", "Rebelo", LocalDate.MAX),
            new Person(3, "Darwin", "Mustafa", LocalDate.MIN),
            new Person(4, "Emil", "Johansson", LocalDate.parse("1990-01-01"))

    ));


    public static void main(String[] args) {
        Filter<Person> findById1 = person -> person.getId() == 1;
        find(people,findById1);


        Filter<Person> findByFirstName = person -> person.getFirstName().equals("Darwin");
        find(people,findByFirstName);


        find(
                people,
                p -> p.getBirthDate().equals(LocalDate.MAX),
                p -> System.out.println(p)
        );

        find(people, p -> p.getBirthDate().equals(LocalDate.MAX));

    }

    public static <T> void find(Collection<T> source, Filter<T> filter){
        for (T obj : source) {
            if (filter.test(obj)) {
                System.out.println(obj);
            }
        }
    }

    public static <T> void find(Collection<T> source, Filter<T> predicate, Action<T> consumer){
        for (T obj : source) {
            if (predicate.test(obj)) {
                consumer.consume(obj);
            }
        }
    }

}
