import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PersonSet {
  private List<MasterNumber> masterNumbers;

  private List<Address> addresses;

  private List<Telephone> telephones;

  private List<Email> emails;

  public PersonSet(List<MasterNumber> masterNumbers,
                   List<Telephone> telephones,
                   List<Address> addresses,
                   List<Email> emails) {
    this.masterNumbers = masterNumbers;
    this.addresses = addresses;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Stream<Person> groupToPeople() {
    // TODO: group the data to Stream<Person>
    // Can use Collectors.groupingBy method
    // Can add helper method
    List<Person> people = new ArrayList<>();
    for (MasterNumber number : masterNumbers) {
      Address address = null;
      for (Address ad : addresses) {
        if (ad.getMasterNumber().equals(number.getNumber())) {
          address = ad;
          break;
        }
      }

      List<Telephone> tps = new ArrayList<>();
      for (Telephone telephone : telephones) {
        if (telephone.getMasterNumber().equals(number.getNumber())) {
          tps.add(telephone);
        }
      }

      List<Email> ems = new ArrayList<>();
      for (Email email : emails) {
        if (email.getMasterNumber().equals(number.getNumber())) {
          ems.add(email);
        }
      }

      people.add(new Person(number.getNumber(), tps, address, ems));
    }
   return people.stream();
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setMasterNumbers(List<MasterNumber> masterNumbers) {
    this.masterNumbers = masterNumbers;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }
}
