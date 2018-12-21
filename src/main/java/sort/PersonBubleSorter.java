package sort;

import entities.Person;

import java.util.Comparator;

public class PersonBubleSorter implements PersonSorter {

    /**
     * Сортировка пузырьком (по убыванию)
     * @param p
     * @param comparator
     */
    @Override
    public void sort(Person[] p, Comparator<Person> comparator) {
        Person temp;
        /*for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1; j++) {
                if (comparator.compare(p[i], p[j + 1]) > 0) {
                    temp = p[j + 1];
                    p[j + 1] = p[i];
                    p[i] = temp;
                }
            }
        }*/
        for (int i = 0; i < p.length; i++) {
            for (int j = p.length - 1; j > i; j--) {
                if (comparator.compare(p[j - 1], p[i]) > 0) {
                    temp = p[j - 1];
                    p[j - 1] = p[i];
                    p[i] = temp;
                }
            }
        }
    }

}
