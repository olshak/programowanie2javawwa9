package optional.discount;

public class Discount {
  private String name;
  private Integer value;

  public Discount(String name, Integer value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Integer getValue() {
    return value;
  }

}
