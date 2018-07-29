package decorator.affix;

import decorator.words.Word;

public class UnPrefix extends AbstractWordDecorator {
    public UnPrefix(Word word) {
        super(word);
    }

    @Override
    public String display() {
        return "un" + word.display();
    }
}
