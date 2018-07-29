package decorator.affix;

import decorator.words.Word;

public abstract class AbstractWordDecorator implements Word {
    protected Word word;

    public AbstractWordDecorator(Word word) {
        this.word = word;
    }
}
