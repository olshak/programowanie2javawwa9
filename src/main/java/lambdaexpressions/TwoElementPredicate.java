package lambdaexpressions;

public interface TwoElementPredicate <SomeType> {

    // Używając typów generycznych zamień rozwiązania używające klasy String na takie, które będą mogły przyjąć
    // dowolny element tj. zamień betterString na betterEntry i TwoStringPredicate na TwoElementPredicate. Teraz
    // powinieneś mieć możliwość przekazania do metody betterElement dowolne elementy. Na przykład 2 samochody i
    // predykat samochodowy, 2 pracowników i predykat pracowniczy, itd. :
    //• ElementUtils.betterElement(string1, string2, (s1, s2) -> s1.length() > s2.length())
    //• ElementUtils.betterElement(car1, car2, (c1, c2) -> c1.getPrice() > c2.getPrice())
    //• ElementUtils.betterElement(employee1, employee2, (e1, e2) -> e1.getSalary() > e2.getSalary())

    boolean verify(SomeType element1, SomeType element2);
}
