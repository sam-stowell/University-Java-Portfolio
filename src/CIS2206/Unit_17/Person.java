package CIS2206.Unit_17;

import java.util.Objects;

/**
 * Implements a domain class representing a person
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class Person {
    String name;
    String surname;
    Integer age;

    /**
     * This constructor initialises the fields of the class
     *
     * @param name The first name of the person
     * @param surname The last name of the person
     * @param age The age of the person
     */
    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    /**
     * This method creates a String representation of
     * the object in a human friendly fashion.
     *
     * @return A String representation of the person
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
