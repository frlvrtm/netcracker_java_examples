package sort;

import entities.Person;

import java.util.Comparator;

public class PersonSelectionSorter implements PersonSorter {

    /**
     * Сортировка выбором
     *
     * @param p
     * @param comparator
     */
    @Override
    public void sort(Person[] p, Comparator<Person> comparator) {
        Person temp;
        int min;
        for (int i = 0; i < p.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < p.length; j++) {
                if (comparator.compare(p[j], p[min]) > 0) {
                    min = j;
                }
            }
            temp = p[min];
            p[min] = p[i];
            p[i] = temp;
        }
    }

}
