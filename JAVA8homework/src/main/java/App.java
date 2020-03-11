import entity.Address;
import entity.MasterNumber;

import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    PersonService personService = new PersonService();
    //TODO: print Person data that masterNumber is 1 and 2
    // print Person data that masterNumber is 3
    personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("1")))
            .forEach(person -> System.out.println(person));
    personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("2")))
            .forEach(person -> System.out.println(person));
    personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3")))
            .forEach(person -> System.out.println(person));
  }

}
