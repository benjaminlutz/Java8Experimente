package java8;

import java8.domain.Gender;
import java8.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Diverse kleine Testmethoden für die Java 8 Stream API.
 *
 * @author Benjamin Lutz
 */
public class Java8StreamAPI {

    final List<Person> personList = new ArrayList<>();

    void fillPersonListWithDummyData() {
        personList.add(new Person("Hans", "Wurst", 18, Gender.MALE));
        personList.add(new Person("Lieschen", "Müller", 17, Gender.FEMALE));
    }

    public List<Person> getPersonsFilteredByGender(Gender gender) {
        return personList.stream()
                .filter(person -> person.getGender() == gender)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getAllPreNamesAsList() {
        return personList.stream()
                .map(Person::getPreName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String getAllSurNamesAsCommaSeparatedList() {
        return personList.stream()
                .map(Person::getSurName)
                .collect(Collectors.joining(", "));
    }

    public int getTotalAgeOfAllPersons() {
        return personList.stream()
                .mapToInt(Person::getAge)
                .sum();
    }

    public int getAgeOfYoungestPerson() {
        return personList.stream()
                .mapToInt(Person::getAge)
                .sorted()
                .findFirst()
                .orElse(0);
    }

    public double getAverageAgeOfAllPersons() {
        return personList.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics()
                .getAverage();
    }
}
