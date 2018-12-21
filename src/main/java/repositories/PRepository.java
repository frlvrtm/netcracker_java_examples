package repositories;

import inject.Inject;
import check.FioPersonChecker;
import check.PersonChecker;
import comparators.AgePersonSorter;
import comparators.FioPersonSorter;
import sort.PersonSorter;
import entities.Person;
import org.apache.log4j.Logger;

import java.io.FileReader;

/**
 * Класс Repository
 */
public class PRepository {

    final static Logger logger = Logger.getLogger(FileReader.class);

    /**
     * Инициализирует массив объектов
     */
    private Person[] person = new Person[0];

    @Inject
    private PersonSorter sorter;

    /**
     * Возвращает длину массива
     *
     * @return
     */
    public int size() {
        return person.length;
    }

    /**
     * Добавляет новый объект в массив
     *
     * @param p
     */
    public void addPerson(Person p) {
        try {
            Person[] temp = new Person[person.length + 1];
            for (int i = 0; i < person.length; i++) {
                temp[i] = person[i];
            }
            temp[temp.length - 1] = p;
            this.person = temp;
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Удаляет объект из массива по заданному параметру
     *
     * @param id
     */
    public void remove(int id) {
        try {
            int size = person.length;
            for (int i = 0; i < size; i++) {
                if (person[i].getId() == id) {
                    person[i] = person[size - 1];
                    person[size - 1] = null;
                    size--;
                    return;
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Выводит в консоль все объекты массива
     */
    public void findAll() {
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
    }

    /**
     * Осуществляет поиск объекта по ФИО
     *
     * @param fio
     * @return
     */
    public PRepository searchByFio(String fio) {
        return search(new FioPersonChecker(), fio);
    }

    /**
     * Осуществляет поиск объекта по дате рождения
     *
     * @param date
     * @return
     */
    public PRepository searchByBirthDate(int date) {
        return search((p, a) -> p.getBirthDay().equals(a), date);
    }

    private PRepository search(PersonChecker checker, Object value) {
        PRepository result = new PRepository();
        for (int i = 0; i < size(); i++) {
            if (checker.check(person[i], value)) {
                result.addPerson(person[i]);
            }
        }
        return result;
    }

    /**
     * Сортирует объекты по ФИО (в алфавитном порядке, А-Я)
     */
    public void sortByFio() {
        sorter.sort(person, new FioPersonSorter());
    }

    /**
     * Сортирует объекты по возрасту (в порядке возрастания)
     */
    public void sortByAge() {
        sorter.sort(person, new AgePersonSorter());
    }
}
