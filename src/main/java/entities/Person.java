package entities;

import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.util.Comparator;

/**
 * Класс Person
 */
public class Person {

    /**
     * Поле ID
     */
    private int id;

    /**
     * Поле "Фамилия"
     */
    private String lastname;

    /**
     * Поле "Имя"
     */
    private String firstname;

    /**
     * Поле "Отчество"
     */
    private String middlename;

    /**
     * Поле "ФИО"
     */
    private String name;

    /**
     * Поле "пол"
     */
    private String gender;

    /**
     * Поле "Дата рождения"
     */
    private LocalDate birthDay;

    /**
     * Пустой конструктор
     */
    public Person() {
    }

    /**
     * Конструктор с параметрами
     *
     * @param id
     * @param lastname
     * @param firstname
     * @param middlename
     * @param gender
     * @param birthDay
     */
    public Person(int id, String lastname, String firstname, String middlename, String gender, LocalDate birthDay) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getName() {
        return lastname + " " + firstname + " " + middlename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * Вычисляемое поле "Возраст"
     *
     * @param birthDate
     * @param currentDate
     * @return
     */
    public int getAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.fieldDifference(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Person " +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay + '\'' +
                ", age=" + getAge(birthDay, LocalDate.now()) +
                '\n';
    }

}
