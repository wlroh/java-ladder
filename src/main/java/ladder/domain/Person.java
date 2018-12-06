package ladder.domain;

import ladder.exception.FormatException;

import java.util.Objects;

public class Person {

    private static final int STANDARD_LENGTH = 5;
    private String name;

    private Person(String name) {
        if (name.length() > STANDARD_LENGTH) {
            throw new FormatException();
        }
        this.name = name;
    }

    public static Person from(String name) {
        return new Person(name);
    }

    private int getLengthCount() {
        return STANDARD_LENGTH - this.name.length();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        for (int i = 0; i < getLengthCount(); i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}