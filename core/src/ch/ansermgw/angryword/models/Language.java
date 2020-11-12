package ch.ansermgw.angryword.models;

public class Language {
    private String iso_639_1;
    private String displayLanguage;

    public Language(String displayLanguage, String iso_639_1) {
        this.displayLanguage = displayLanguage;
        this.iso_639_1 = iso_639_1;
    }

    public String getDisplayLanguage() {
        return displayLanguage;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }
}
