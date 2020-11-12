package ch.ansermgw.angryword.models;

import java.util.HashMap;

public class SemanticWord {
    private final HashMap<String, String> semanticWord;

    public SemanticWord() {
        semanticWord = new HashMap<>();
    }

    public void addTranslation(String language, String value) {
       this.semanticWord.put(language, value);
    }

    public String getLanguageValue(String language) {
        String value = semanticWord.get(language);
        return value;
    }

}
