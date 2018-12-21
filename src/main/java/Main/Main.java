package Main;

import inject.Injector;
import entities.Person;
import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import repositories.PRepository;

import java.io.FileReader;

/**
 * Класс Main
 */
public class Main {

    /**
     * Константа, содержит формат записи даты
     */
    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static PRepository repository = new PRepository();
    final static Logger logger = Logger.getLogger(FileReader.class);

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        (new Injector()).inject(repository);
        Person p1 = new Person(1, "Иванов", "Иван", "Иванович", "мужской", format.parseLocalDate("1960-12-14"));
        Person p2 = new Person(2, "Петров", "Петр", "Петрович", "мужской", format.parseLocalDate("1987-10-08"));
        Person p3 = new Person(3, "Виноградова", "Мария", "Александровна", "женский", format.parseLocalDate("1999-03-30"));
        repository.addPerson(p1);
        repository.addPerson(p2);
        repository.addPerson(p3);
        logger.info("Были добавлены 3 записи. Размер массива = " + repository.size());

        repository.findAll();

/*
        System.out.println("-----------------------------------");
        logger.info("Поиск записи по ФИО: " + "\n" + repository.searchByFio("Иванов Иван Иванович"));

        System.out.println("-----------------------------------");
        logger.info("Поиск записи по дате рождения: " + "\n" + repository.searchByBirthDate(1960-12-14));
*/

        System.out.println("-----------------------------------");
        repository.sortByFio();
        repository.findAll();
        logger.info("Сортировка данных по ФИО");

        System.out.println("-----------------------------------");
        repository.sortByAge();
        repository.findAll();
        logger.info("Сортировка данных по возрасту");
    }

}
