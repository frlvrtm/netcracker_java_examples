package repositories;

import entities.Person;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PRepositoryTest {

    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
    private PRepository repository = new PRepository();

    @Test
    public void addPerson() {
        Person p1 = new Person(1, "Иванов", "Иван", "Иванович", "мужской", format.parseLocalDate("1960-12-14"));
        repository.addPerson(p1);
        Assert.assertEquals(1, repository.size());
    }

    @Test
    public void remove() {
        repository.remove(1);
        Assert.assertEquals(0, repository.size());
    }

}