package collections;

import java.util.*;

public class Collections {

  // "ala ma kota kot ma ala"
  public static Map<String, Integer> countOccurrences(String sentence) {
    String[] words = sentence.split(" ");

    Map<String, Integer> wordOccurrences = new HashMap<>();

    //1 jesli slowa nie bylo w mapie -> dodajemy z wartoscia 1
    //2 jesli slowo juz bylo w mapie -> dodajemy z poprzednia wartoscia powiekszona o 1

    for (String word : words) {
      if (!wordOccurrences.containsKey(word)) {
        wordOccurrences.put(word, 1);
      } else {
        wordOccurrences.put(word, wordOccurrences.get(word) + 1);
      }
    }

    return wordOccurrences;
  }

  public static int countUniqueLetters(String word) {
    Set<Character> characters = new HashSet<>();
    for (int i = 0; i < word.length(); i++) {
      characters.add(word.charAt(i));
    }
    return characters.size();
  }

  // literki nie ma w mapie -> dodajemy literkę wraz z indeksem na którym była, ten indeks dodajemy do listy
  // literka była w mapie -> dodajemy indeks do listy

  public static Map<Character, List<Integer>> conconrdance(String sentence) {
    Map<Character, List<Integer>> concordance = new HashMap<>();

    sentence = sentence.replace(" ", "");

    for (int i = 0; i < sentence.length(); i++) {
      Character currentCharacter = sentence.charAt(i);
      if(!concordance.containsKey(currentCharacter)) {
        List<Integer> occurrences = new ArrayList<>();
        occurrences.add(i);
        concordance.put(currentCharacter, occurrences);
      } else {
        concordance.get(currentCharacter).add(i);
      }
    }
    return concordance;
  }

  public static void main(String[] args) {
    System.out.println(countOccurrences("ala ma kota kot ma ala ala ala ala"));

    System.out.println(countUniqueLetters("kopytko"));

    System.out.println(conconrdance("Hello World"));

  }
}