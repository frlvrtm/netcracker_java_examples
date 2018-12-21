package comparators;

import entities.Person;
import org.joda.time.LocalDate;

import java.util.Comparator;

public class AgePersonSorter implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge(o1.getBirthDay(), LocalDate.now()) > o2.getAge(o2.getBirthDay(), LocalDate.now()))
            return 1;
        else if (o1.getAge(o1.getBirthDay(), LocalDate.now()) < o2.getAge(o2.getBirthDay(), LocalDate.now()))
            return -1;
        else
            return 0;
    }

}
