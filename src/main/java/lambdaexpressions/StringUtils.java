package lambdaexpressions;

public class StringUtils {

    // Głownym celem tego zadania jest stworzenie metody betterString, która przyjmuje dwa Stringi i wyrażenie lambda,
    // które stwierdza, który z tych Stringów jest „lepszy”. Np. jeśli wyrażenie lambda zwróci true metoda
    // betterString powinna zwrócić pierwszy element, w przeciwnym razie drugi.

    //Aby wykonać to zadanie należy zrobić 3 rzeczy:
    //1. Zdefiniować interfejs TwoStringPredicate. Ma on posiadać jedną metodę, która przyjmuje dwa Stringi i zwraca
    // wartość boolean.
    //2. Stworzyć metodę statyczną betterString. Ta metoda ma przyjmować dwa Stringi i instancję interfejsu
    // zdefiniowanego w 1 punkcie. Ma zwrócić string1 jeśli metoda z interfejsu zwróci true, string2 w przeciwnym razie.
    //3. Zawołaj metodę betterString. Możesz teraz używać wyrażeń lambda w miejsce 3go argumentu, tak jak w
    // przykładzie powyżej.

    public static String betterString(String s1, String s2, TwoStringPredicate predicate) {
        return predicate.verify(s1, s2) ? s1 : s2;
    }

    public static void main(String[] args) {
        System.out.println(
                betterString(
                        "jestem dluzszy",
                        "krotszy",
                        (s1, s2) -> s1.length() > s2.length()
                ));

        System.out.println(
                betterString(
                        "pierwszy",
                        "drugi",
                        (s1, s2) -> true
                ));
    }
}
