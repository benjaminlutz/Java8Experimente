package java8.domain;

/**
 * Person object.
 *
 * @author Benjamin Lutz
 */
public class Person {

    private String preName;

    private String surName;

    private int Age;

    private Gender gender;

    public Person(String preName, String surName, int age, Gender gender) {
        this.preName = preName;
        this.surName = surName;
        Age = age;
        this.gender = gender;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
