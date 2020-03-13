import entity.MasterNumber;

import java.util.Arrays;
import java.util.List;

public class App {

  public static void main(String[] args) {
    //TODO: print Person data that masterNumber is 1 and 2
    // print Person data that masterNumber is 3
    printPersonByMasterNumber(Arrays.asList(new MasterNumber("1"), new MasterNumber("2"))) ;
    printPersonByMasterNumber(Arrays.asList(new MasterNumber("3")));
  }

  public static void printPersonByMasterNumber(List<MasterNumber> masterNumbers) {
    PersonService personService = new PersonService();
    personService.getPersonByMasterNumbers(masterNumbers)
            .forEach(System.out::println);
  }

}
