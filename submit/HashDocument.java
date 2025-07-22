import java.util.*;

/**
 * This class is for storing the content of a document.
 * That should map each word to their corresponding wordFrequency.
 */
public class HashDocument {
    // added instance variables
    private String title;
    private Map<String, WordFrequency> hashMap;
    private int totalWords;
    /**
     * Constructor for HashDocument class.
     * @param t title of the document
     * @param c content of the document
     */
    public HashDocument(String t, String c)
    {
        this.title = t;
        this.hashMap = new HashMap<>();
        this.totalWords = 0;
        processWords(c);
    }

    /**
     * Getter method for title.
     * @return title of the document
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Breaks up content into words, skipping punctuations.
     * and keeping only words that have more than 3 characters.
     * @param content - all the text from a file to be processed
     */
    private void processWords(String content) {
        // Use regular expression to pick up words only
        String[] words = content.split("\\W+");
        for (String word : words) {
            // and process only words longer than 3 characters
            if (word.length() > 3) {
                addWord(word.toLowerCase());
            }
        }
    }

    /**
     * Returns the frequency of the word in the document.
     * @param w word to be checked
     * @return frequency of the word (0 if not found)
     */
    public int frequency(String w) {
        WordFrequency wf = hashMap.get(w.toLowerCase());
        if (wf == null) {
            return 0;
        } else {
            return wf.getCount();
        }
    }

    /**
     * Adds a word to the document.
     * @param w word to be added
     */
    public void addWord(String w) {
        WordFrequency wf = hashMap.get(w);
        if (wf == null) {
            wf = new WordFrequency(w);
            hashMap.put(w, wf);
        } else {
            wf.increment();
        }
        totalWords++;
    }

    /**
     * Checks if the word is in the document.
     * @param w word to be checked
     * @return true if the word is in the document, false otherwise
     */
    public boolean contains(String w) {
        return hashMap.containsKey(w.toLowerCase());
    }

    /**
     * Returns the number of unique words stored in HashMap.
     * @return number of unique words
     */
    public int numUniqueWordsInTable() {
        return hashMap.size();
    }

    /**
     * Returns the total number of words in the document.
     * @return total number of words
     */
    public int totalNumOfWords() {
        return totalWords;
    }

    /**
     * Returns the most common word in hashMap.
     * @return most common word
     */
    public String mostCommonWord() {
        String mostCommon = null;
        int maxFrequency = 0;
        for (WordFrequency wf : hashMap.values()) {
            if (wf.getCount() > maxFrequency) {
                mostCommon = wf.getWord();
                maxFrequency = wf.getCount();
            }
        }
        return mostCommon;
    }

    /**
     * Computes the term frequency of the word in the document.
     * @param w word to be checked
     * @return term frequency of the word
     */
    public double termFrequency(String w) {
        if (totalWords == 0) {
            return 0.0;
        }
        return (double) frequency(w) / totalWords;
    }

}
