package lambdaexpressions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressions {

    // 1. Napisz metodę, która zwróci średnią z listy integerów.
    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(value -> value)
                .average()
                .orElse(0);
    }

    // 2. Napisz metodę, która skonwertuje wszystkie Stringi z podanej listy, aby były zapisane wielkimi literami.
    public static List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // 3. Napisz metodę, która przyjmuje listę Stringów i zwróci listę wszystkich, które zaczynają się na „s” i mają
    // dokładnie 4 litery.
    public static List<String> startsWithSAndHasFourLetters(List<String> list) {
        return list.stream()
                .filter(element -> (element.startsWith("s") || element.startsWith("S")) && element.length() == 4)
                .collect(Collectors.toList());
    }

    // 4. Napisz metodę która, dostając listę integerów, zwróci Stringa z wartościami oddzielonymi przecinkami.
    // Każdy element powinien być poprzedzony literą „p” jeśli jest parzysty, a literą „n” jeśli jest nieparzysty. Na
    // przykład dla listy (3, 44) metoda powinna zwrócić „n3, p44”.
    public static String modifyAccordingToOddOrEven(List<Integer> list) {
        return list.stream()
                .map(element -> element % 2 == 0 ? "p" + element : "n" + element)
                .collect(Collectors.joining(", "));
    }

    // 5. Stwórz metodę sortującą alfabetycznie listę stringów
    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 6. Stwórz metodę sortującą listę stringów w kolejności odwrotnej do alfabetycznej
    public static List<String> sortReverseAlphabetically(List<String> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // 7. Stwórz metodę sortującą alfabetycznie listę stringów,  ale tylko według pierwszego znaku.
    public static List<String> sortOnlyAccordingToFirstChar(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(e -> e.charAt(0)))
                .collect(Collectors.toList());
    }

    // 8. Stwórz metodę sortującą, która posortuje Stringi tak, że na początku będą wyrazy zaczynające się na „e”, a
    // dalej cała reszta. (Podpowiedź: lambda może zawierać nawiasy wąsate i słowo kluczowe return)
    public static List<String> sortIfStartsWithE(List<String> list) {
        return list.stream()
                .sorted((e1, e2) -> {
                    int sortFlag = 0;
                    if (e1.charAt(0) == 'e' && e2.charAt(0) != 'e') {
                        sortFlag = -1;
                    } else if (e1.charAt(0) != 'e' && e2.charAt(0) == 'e') {
                        sortFlag = 1;
                    }
                    return sortFlag;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //average
        List<Integer> integerList = Arrays.asList(-20, 4, 6, 10, 20);
        System.out.println(average(integerList));

        //upperCase
        List<String> stringList = Arrays.asList("asd", "DeS", "DES", "DsdasdSdS", "asdD");
        System.out.println(upperCase(stringList));

        //startsWithSAndHasFourLetters
        List<String> stringListStartingWithS = Arrays.asList("asd", "SeSd", "SES", "ssdS", "sasdD");
        System.out.println(startsWithSAndHasFourLetters(stringListStartingWithS));

        //modifyAccordingToOddOrEven
        List<Integer> evenOddIntegers = Arrays.asList(-20, 3, 5, 10, 20, 123);
        System.out.println(modifyAccordingToOddOrEven(evenOddIntegers));

        //sortAlphabetically
        List<String> listToSort = Arrays.asList("ac", "aa", "asd");
        System.out.println(sortAlphabetically(listToSort));

        //sortReverseAlphabetically
        List<String> listToSortReverse = Arrays.asList("ac", "aa", "asd");
        System.out.println(sortReverseAlphabetically(listToSortReverse));

        //sortOnlyAccordingToFirstChar
        List<String> listToSortFirstChar = Arrays.asList("ac", "aa", "asd");
        System.out.println(sortOnlyAccordingToFirstChar(listToSortFirstChar));

        //sortIfStartsWithE
        List<String> listToSortE = Arrays.asList("ed", "asd", "edsa", "dfrfw", "ead", "eda");
        System.out.println(sortIfStartsWithE(listToSortE));
    }
}
