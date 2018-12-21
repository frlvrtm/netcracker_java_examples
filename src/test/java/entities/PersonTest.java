package entities;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
    private Person p = new Person();

    @Test
    public void getAge() {
        LocalDate birthDate = format.parseLocalDate("1960-12-14");
        LocalDate currentDate = format.parseLocalDate("2018-12-02");
        int age = p.getAge(birthDate, currentDate);
        Assert.assertEquals(58, age);
    }

}