package optional.discount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiscountRepository {
  private List<Discount> discounts;

  public DiscountRepository(List<Discount> discounts) {
    this.discounts = discounts;
  }

  public Optional<Discount> getDiscount(String name) {
    for (Discount discount :discounts) {
      if (discount.getName().equals(name)) {
        return Optional.of(discount);
      }
    }
    return Optional.empty();
  }

  public static void main(String[] args) {
    List<Discount> discounts = new ArrayList<>();
    Discount janusz = new Discount("Janusz",100);
    Discount haloween = new Discount("Haloween",10);
    Discount newYear = new Discount("NewYear",20);

    discounts.add(janusz);
    discounts.add(haloween);
    discounts.add(newYear);

    DiscountRepository discountRepository = new DiscountRepository(discounts);

    int productPrice = 1000;
//    Optional<Discount> maybeDiscount = discountRepository.getDiscount("Janusz");
//    int discount = 0;
//    if (maybeDiscount.isPresent()) {
//      discount = maybeDiscount.get().getValue();
//    }
//    int finalPrice = productPrice - discount;

    int finalPrice = productPrice - discountRepository.getDiscount("Janusz").map(Discount::getValue).orElse(0);

    System.out.println(finalPrice);

  }
}
