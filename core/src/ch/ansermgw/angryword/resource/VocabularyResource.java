package ch.ansermgw.angryword.resource;

import ch.ansermgw.angryword.activities.Play;

import java.util.ArrayList;
import java.util.List;

public class VocabularyResource {
    private final List<WordResource> words;
    private final String name;

    public VocabularyResource(ArrayList<WordResource> words, String name) {
        this.words = words;
        this.name = name;
    }

    public VocabularyResource(String name) {
        words = new ArrayList<>();
        this.name = name;
    }

    public void addWord(WordResource word) {
        words.add(word);
    }

    public WordResource getRandomUnusedWordResource() {
        List<WordResource> unusedWord = new ArrayList<>();

        for (WordResource word : words) {
            if (!word.isUsed()) {
                unusedWord.add(word);
            }
        }

        return getRandomWordResourceFromList(unusedWord);
    }

    public WordResource getRandomUsedWordResource() {
        List<WordResource> usedWord = new ArrayList<>();

        for (WordResource word : words) {
            if (word.isUsed()) {
                usedWord.add(word);
            }
        }

        return getRandomWordResourceFromList(usedWord);
    }

    private WordResource getRandomWordResourceFromList(List<WordResource> wordResources) {
        if (wordResources.size() < 1) {
            return null;
        }

        return wordResources.get(Play.rand.nextInt(wordResources.size()));
    }
}
