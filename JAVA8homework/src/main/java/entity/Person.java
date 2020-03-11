package entity;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Person {

  private String masterNumber;
  private Address address;

  private List<Telephone> telephones;

  private List<Email> emails;

  public Person() {
  }

  public Person(String masterNumber, List<Telephone> telephones, Address address,
                List<Email> emails) {
    this.masterNumber = masterNumber;
    this.address = address;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Optional<SimpleAddress> getSimpleAddress() {
    //TODO: return Optional<SimpleAddress>
    try {
      address.getStreet();
      address.getCity();
    } catch (Exception e) {
      return Optional.ofNullable(null);
    }
    SimpleAddress simpleAddress = new SimpleAddress(address.getStreet(), address.getCity());
    return Optional.ofNullable(simpleAddress);
  }

  public Address getAddress() {
    return address;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public String getMasterNumber() {
    return masterNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(masterNumber, person.masterNumber) &&
            Objects.equals(address, person.address) &&
            Objects.equals(telephones, person.telephones) &&
            Objects.equals(emails, person.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, address, telephones, emails);
  }

  @Override
  public String toString() {
    return "Person{" +
            "masterNumber='" + masterNumber + '\'' +
            ", address=" + address +
            ", telephones=" + telephones +
            ", emails=" + emails +
            '}';
  }
}
