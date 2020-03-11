import entity.MasterNumber;
import entity.Person;

import java.util.*;
import java.util.stream.Stream;

public class PersonService {

  private Map<List<String>, Optional<PersonSet>> people;

  public PersonService() {
    this.people = new HashMap<>();
    people.put(Arrays.asList("1"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1()));
    people.put(Arrays.asList("1", "2"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1And2()));
  }

  public Stream<Person> getPersonByMasterNumbers(List<MasterNumber> numbers) {
    //TODO: Add the code to return people by numbers
    // Use groupToPeople() method
    String number = numbers.get(0).getNumber();
    Stream<Person> personStream = Arrays.asList(new Person()).stream();
    for (Map.Entry<List<String>, Optional<PersonSet>> entry : people.entrySet()) {
      if (entry.getKey().contains(number)) {
        return entry.getValue().get().groupToPeople().filter(person -> person.getMasterNumber().equals(number));
      }
    }
    return personStream.skip(1);
  }

}
