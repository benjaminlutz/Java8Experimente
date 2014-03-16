package java8;

import java8.domain.Gender;
import java8.domain.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Test of class {@link java8.Java8StreamAPI}.
 *
 * @author Benjamin Lutz
 */
public class Java8StreamAPITest {

    private Java8StreamAPI java8StreamAPI;

    @Before
    public void setUp() throws Exception {
        java8StreamAPI = new Java8StreamAPI();
        java8StreamAPI.fillPersonListWithDummyData();
    }

    @After
    public void tearDown() throws Exception {
        java8StreamAPI = null;
    }

    @Test
    public void testBuildPersonList() throws Exception {
        assertEquals(2, java8StreamAPI.personList.size());
    }

    @Test
    public void testGetPersonsFilteredByGender() throws Exception {
        List<Person> filteredPersonList = java8StreamAPI.getPersonsFilteredByGender(Gender.MALE);
        assertEquals(1, filteredPersonList.size());

        filteredPersonList.forEach(person -> assertEquals(Gender.MALE, person.getGender()));
    }

    @Test
    public void testGetAllPreNamesAsString() throws Exception {
        List<String> preNames = java8StreamAPI.getAllPreNamesAsList();
        assertEquals(2, preNames.size());

        assertEquals("Hans", preNames.get(0));
        assertEquals("Lieschen", preNames.get(1));
    }

    @Test
    public void testGetAllSurNamesAsCommaSeparatedList() throws Exception {
        assertEquals("Wurst, Müller", java8StreamAPI.getAllSurNamesAsCommaSeparatedList());
    }

    @Test
    public void testGetTotalAgeOfAllPersons() throws Exception {
        assertEquals(35, java8StreamAPI.getTotalAgeOfAllPersons());
    }

    @Test
    public void testGetAgeOfYoungestPerson() throws Exception {
        assertEquals(17, java8StreamAPI.getAgeOfYoungestPerson());
    }

    @Test
    public void testGetAverageAgeOfAllPersons() throws Exception {
        assertEquals(17.5, java8StreamAPI.getAverageAgeOfAllPersons(), 0.1);
    }
}
