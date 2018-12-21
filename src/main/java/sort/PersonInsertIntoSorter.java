package sort;

import entities.Person;

import java.util.Comparator;

public class PersonInsertIntoSorter implements PersonSorter {

    /**
     * Сортировка вставками
     *
     * @param p
     * @param comparator
     */
    @Override
    public void sort(Person[] p, Comparator<Person> comparator) {
        for (int i = 1; i < p.length; i++) {
            Person temp = p[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (comparator.compare(p[j], temp) > 0)
                    break;
                p[j + 1] = p[j];
            }
            p[j + 1] = temp;
        }
    }

}
