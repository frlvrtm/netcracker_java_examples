package entities;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import xml.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Класс Person
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    /**
     * Поле ID
     */
    @XmlAttribute(name = "id")
    private int id;

    /**
     * Поле "Фамилия"
     */
    @XmlAttribute(name = "lastname")
    private String lastname;

    /**
     * Поле "Имя"
     */
    @XmlAttribute(name = "firstname")
    private String firstname;

    /**
     * Поле "Отчество"
     */
    @XmlAttribute(name = "middlename")
    private String middlename;

    /**
     * Поле "ФИО"
     */
    private String name;

    /**
     * Поле "пол"
     */
    @XmlAttribute(name = "gender")
    private String gender;

    /**
     * Поле "Дата рождения"
     */
    @XmlAttribute(name = "birthDay")
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    //Позволяет задать класс, который будет преобразовывать данные поля в строку
    private LocalDate birthDay;

    /**
     * Пустой конструктор
     */
    public Person() {
    }

    /**
     * Конструктор с параметрами
     *
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
        return "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay + '\'' +
                ", age=" + getAge(birthDay, LocalDate.now()) +
                '\n';
    }

}
