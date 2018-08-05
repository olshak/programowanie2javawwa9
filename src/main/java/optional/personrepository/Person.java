package optional.personrepository;

public class Person {
  private int id;
  private String name;
  private String surname;
  private int age;

  public Person(int id, String name, String surname, int age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        '}';
  }
}
