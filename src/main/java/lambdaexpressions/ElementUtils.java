package lambdaexpressions;

public class ElementUtils {

    // Używając typów generycznych zamień rozwiązania używające klasy String na takie, które będą mogły przyjąć
    // dowolny element tj. zamień betterString na betterEntry i TwoStringPredicate na TwoElementPredicate. Teraz
    // powinieneś mieć możliwość przekazania do metody betterElement dowolne elementy. Na przykład 2 samochody i
    // predykat samochodowy, 2 pracowników i predykat pracowniczy, itd. :
    //• ElementUtils.betterElement(string1, string2, (s1, s2) -> s1.length() > s2.length())
    //• ElementUtils.betterElement(car1, car2, (c1, c2) -> c1.getPrice() > c2.getPrice())
    //• ElementUtils.betterElement(employee1, employee2, (e1, e2) -> e1.getSalary() > e2.getSalary())

    public static <SomeType> SomeType betterElement(SomeType e1, SomeType e2, TwoElementPredicate<SomeType> predicate) {
        return predicate.verify(e1, e2) ? e1 : e2;
    }

    public static void main(String[] args) {
        System.out.println(
                betterElement(
                        "jestem dluzszy",
                        "krotszy",
                        (s1, s2) -> s1.length() > s2.length()
                ));

        System.out.println(
                betterElement(
                        "pierwszy",
                        "drugi",
                        (s1, s2) -> true)
        );

        System.out.println(
                betterElement(
                        123,
                        321,
                        (s1, s2) -> s1 < s2
                ));

        System.out.println(
                betterElement(
                        123.2,
                        321.2,
                        (s1, s2) -> s1 < s2
                ));
    }
}
