package optional.personrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository {
  private List<Person> people;

  public PersonRepository(List<Person> people) {
    this.people = people;
  }

  public void addPerson(Person person) {
    for (Person currentPerson : people) {
      if (currentPerson.getId() == person.getId()) {
        throw new IllegalArgumentException("Person with id: " + person.getId() + " already exists");
      }
    }

    people.add(person);
  }

  public Optional<Person> getPerson(int id) {
    for (Person currentPerson : people) {
      if (currentPerson.getId() == id) {
        return Optional.of(currentPerson);
      }
    }

    return Optional.empty();
  }

//  public Person getPerson1(int id) {
//    for (Person currentPerson : people) {
//      if (currentPerson.getId() == id) {
//        return currentPerson;
//      }
//    }
//
//    return null;
//  }

  public Optional<String> getName(int id) {

//    if (getPerson(id).isPresent()) {
//      return Optional.of(getPerson(id).get().getName());
//    };
//    return Optional.empty();

    return getPerson(id).map(person -> person.getName());
  }


  public static void main(String[] args) {
    PersonRepository personRepository = new PersonRepository(new ArrayList<>());
    personRepository.addPerson(new Person(0, "Jan", "Kowalski", 20));
    personRepository.addPerson(new Person(1, "Adam", "Nowak", 20));
    personRepository.addPerson(new Person(2, "Anna", "Kowalska", 20));
    personRepository.addPerson(new Person(3, "Agata", "Zieba", 20));

    System.out.println(personRepository.getPerson(0));
    System.out.println(personRepository.getPerson(1));
    System.out.println(personRepository.getPerson(2));
    System.out.println(personRepository.getPerson(3));
  }
}
