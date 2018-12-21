package comparators;

import entities.Person;

import java.util.Comparator;

public class FioPersonSorter implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
