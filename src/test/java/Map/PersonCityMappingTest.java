package Map;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class PersonCityMappingTest {
    private PersonCityMapping personCityMapping;
    private List<Person> personList;


    @Before
     public void setUp()throws Exception{
        personCityMapping = new PersonCityMapping();
         personList = setUpPersonList();
    }

    @Test
    public void getCityPersonMapping() {
        Map<String,List<String>> cityPersonList = personCityMapping.getCityPersonMapping(personList);
        assertThat(cityPersonList.get("Glasgow"), hasSize(2));
        assertThat(cityPersonList.get("London"), hasSize(1));
    }

    @Test
    public void getCityPersonMappingWithJava8() {
        Map<String,List<String>> cityPersonList = personCityMapping.getCityPersonMapping(personList);
        assertThat(cityPersonList.get("Glasgow"), hasSize(2));
        assertThat(cityPersonList.get("London").get(0), equalTo("Jonny"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getCityPersonMappingException() {
        Map<String,List<String>> cityPersonList = personCityMapping.getCityPersonMapping(personList);
        assertThat(cityPersonList.get("Glasgow"), hasSize(2));
        assertThat(cityPersonList.get("Edinburgh").get(2), equalTo("Jonny"));
    }

    private List<Person> setUpPersonList(){
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setCity("Glasgow");
        person1.setName("Haary");
        personList.add(person1);
        Person person2 = new Person();
        person2.setCity("Edinburgh");
        person2.setName("Lisa");
        personList.add(person2);
        Person person3 = new Person();
        person3.setCity("Glasgow");
        person3.setName("Martin");
        personList.add(person3);
        Person person4 = new Person();
        person4.setCity("London");
        person4.setName("Jonny");
        personList.add(person4);
        Person person5 = new Person();
        person5.setCity("Edinburgh");
        person5.setName("Raj");
        personList.add(person5);
        return  personList;
    }
}