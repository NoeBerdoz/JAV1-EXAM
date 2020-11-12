package ch.ansermgw.angryword.models;

import java.util.HashMap;

public class SemanticWord {
    private final HashMap<Language, String> semanticWord;
    private boolean isUsed;

    public SemanticWord() {
        semanticWord = new HashMap<>();
        this.isUsed = false;
    }

    public void addTranslation(Language language, String value) {
       this.semanticWord.put(language, value);
    }

    public String getLanguageValue(Language language) {
        return semanticWord.get(language);
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean itsUsed) {
        isUsed = itsUsed;
    }


}
