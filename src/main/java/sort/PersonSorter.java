package sort;

import entities.Person;

import java.util.Comparator;

public interface PersonSorter {

    public void sort(Person[] p, Comparator<Person> comparator);

}
