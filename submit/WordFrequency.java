/**
 * This class is for storing the word and its frequency in the text file.
 * It implements the Comparable interface to compare two WordFrequency objects.
 */
public class WordFrequency implements Comparable<WordFrequency> {
    /**
     * Instance variables for WordFrequency class.
     */
    private String word;
    private int count;
    /**
     * Constructor for WordFrequency class.
     * @param w word to be counted
     */
    public WordFrequency(String w)
    {
        this.word = w;
        this.count = 1;
    }

    /**
     * Getter method for word.
     * @return word stored in the object
     */
    public String getWord()
    {
        return word;
    }

    /**
     * Getter for the count.
     * @return count of the word stored in the object
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Increments/increases the count of the word by 1.
     */
    public void increment()
    {
        count++;
    }

    /**
     * Compares two WordFrequency objects.
     * @param other WordFrequency object to be compared
     * @return 0 if the words are the same, 
     * -1 if the word is lexicographically less than the other word, 
     * 1 if the word is lexicographically greater than the other word
     */
    public int compareTo(WordFrequency other)
    {
        int wordCompare = this.word.compareToIgnoreCase(other.word);
        if (wordCompare != 0)
        {
            return wordCompare;
        } else {
            return Integer.compare(this.count, other.count);
        }
    }
}
