package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonCityMapping {

    public Map<String, List<String>> getCityPersonMapping(List<Person> personList) {

        Map<String, List<String>> cityPersonMap = new HashMap<>();

        for (Person person : personList) {

            if (cityPersonMap.containsKey(person.getCity())) {
                List<String> persons = cityPersonMap.get(person.getCity());
                persons.add(person.getName());
                cityPersonMap.put(person.getCity(), persons);
            } else {
                List<String> persons = new ArrayList<>();
                persons.add(person.getName());
                cityPersonMap.put(person.getCity(), persons);
            }

        }
        return cityPersonMap;

    }

    public Map<String, List<String>> getCityPersonMappingWithJava8(List<Person> personList) {
       return personList.stream().collect(Collectors.groupingBy(Person::getCity,
                Collectors.mapping(Person::getName, Collectors.toList())));

    }
}
