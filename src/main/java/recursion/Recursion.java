package recursion;

public class Recursion {

    // 1. Napisz funkcję, która wyliczy sumę cyfr liczby naturalnej
    public static int sumDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return number % 10 + sumDigits(number / 10);
    }

    // 2. Napisz funkcję, która obliczy wartość n-tego wyrazu ciągu Fibonacciego
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 3. Napisz funkcję pow(int a, int b), która podniesie liczbę a do potęgi b
    public static double power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            return 1 / power(a, -b);
        }
        return a * power(a, b - 1);
    }

    // 4. Napisz funkcję, która odwróci litery w wyrazie
    public static String reverseWord(String word) {
        if (word.equals("")) {
            return "";
        }
        return reverseWord(word.substring(1)) + word.charAt(0);
    }

    // 5. Napisz funkcję, która odwróci kolejność liter w wyrazach w zdaniu np. „ala ma kota” zostanie zamienione na
    // „ala am atok”.
    public static String reverseSentence(String sentence) {
        if (sentence.equals("")) {
            return "";
        }
        int spaceIndex = sentence.indexOf(" ");
        if (spaceIndex == -1) {
            return reverseWord(sentence);
        }
        return reverseWord(sentence.substring(0, spaceIndex)) +
                " " +
                reverseSentence(sentence.substring(spaceIndex + 1, sentence.length()));
    }

    // 6. Napisz funkcję, która sprawdzi, czy dany wyraz jest palindromem
    public static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        return isPalindrome(word.substring(1, word.length() - 1));
    }

    public static void main(String[] args) {
        // 1
        System.out.println(sumDigits(123456789));

        // 2
        System.out.println("fib(0) = " + fibonacci(0));
        System.out.println("fib(1) = " + fibonacci(1));
        System.out.println("fib(2) = " + fibonacci(2));
        System.out.println("fib(3) = " + fibonacci(3));
        System.out.println("fib(4) = " + fibonacci(4));
        System.out.println("fib(5) = " + fibonacci(5));

        // 3
        System.out.println(power(20, -1));

        // 4
        System.out.println(reverseWord("kotek"));

        // 5
        System.out.println(reverseSentence("ala ma kota"));

        // 6
        System.out.println(isPalindrome("aaalaaa"));
        System.out.println(isPalindrome("aaalaba"));
    }
}
