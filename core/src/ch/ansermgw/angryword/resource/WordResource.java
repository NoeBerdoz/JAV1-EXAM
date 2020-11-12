package ch.ansermgw.angryword.resource;

public class WordResource {
    private String word;
    private String translation;
    private boolean isUsed;

    public WordResource(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.isUsed = false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordResource that = (WordResource) o;
        return isUsed == that.isUsed && word == that.word && translation == that.translation;
    }
}
