package decorator;

import decorator.affix.IngSuffix;
import decorator.affix.UnPrefix;
import decorator.words.Do;
import decorator.words.Fuck;
import decorator.words.Word;

public class DecoratorExample {
    public static void main(String[] args) {
        Word word = new UnPrefix(new IngSuffix(new Do()));
        System.out.println(word.display());
        Word curseWord = new UnPrefix(new IngSuffix(new UnPrefix(new IngSuffix(new Fuck()))));
        System.out.println(curseWord.display());
    }
}
