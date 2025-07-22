import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class is testing the HashDocument class.
 */
public class HashDocumentTest {
    // Object to be tested
    private HashDocument runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    
    @Before
    public void setup() {
        runner = new HashDocument("Gettysburg",
        "Four score and seven years ago our fathers brought forth, upon this continent, a new nation, conceived in liberty, and dedicated to the proposition that \"all men are created equal.\"\"\n" +
        "Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived, and so dedicated, can long endure. We are met on a great battle field of that war. We have come to dedicate a portion of it, as a final resting place for those who died here, that the nation might live. This we may, in all propriety do. But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow, this ground -- The brave men, living and dead, who struggled here, have hallowed it, far above our poor power to add or detract. The world will little note, nor long remember what we say here; while it can never forget what they did here.\n" +
        "It is rather for us, the living, to stand here, we here be dedicated to the great task remaining before us -- that, from these honored dead we take increased devotion to that cause for which they here, gave the last full measure of devotion -- that we here highly resolve these dead shall not have died in vain; that the nation, shall have a new birth of freedom, and that government of the people by the people for the people, shall not perish from the earth.\n");
    }

    /**
     * Tests the getTitle method.
     * should return the title of the document
     */
    @Test
    public void testGetTitle() {
        assertEquals("Gettysburg", runner.getTitle());
    }

    /**
     * Tests the contains method.
     * should return true if the word is in the document
     */
    @Test
    public void testContains() {
        assertTrue(runner.contains("nation"));
        assertFalse(runner.contains("unknown"));
    }

    /**
     * Tests the frequency method.
     * should return the frequency of the word
     */
    @Test
    public void testFrequency() {
        assertEquals(1, runner.frequency("four"));
        assertEquals(0, runner.frequency("hello"));
    }

    /**
     * Tests numUniqueWordsInTable method.
     * should return the number of unique words in the document
     */
    @Test
    public void testNumUniqueWordsInTable() {
        assertEquals(91, runner.numUniqueWordsInTable());
    }

    /**
     * Tests totalNumOfWords method.
     * should return the total number of words in the document
     */
    @Test
    public void testTotalNumOfWords() {
        assertEquals(135, runner.totalNumOfWords());
    }

    /**
     * Tests the testMostCommonWord method.
     * should return the most common word in the document
     */
    @Test
    public void testMostCommonWord() {
        assertEquals("that", runner.mostCommonWord());
    }

    /**
     * Tests the termFrequency method.
     * should return the term frequency of the word
     */
    @Test
    public void testTermFrequency() {
        // 5 times "nation" appears in the document
        // divided by the total number of words in document
        assertEquals(5.0 / 135, runner.termFrequency("nation"), 0.001);
        assertEquals(0.0, runner.termFrequency("unknown"), 0.001);
    }
    /**
     * Tests the termFrequency method with an empty HashTable.
     * should return 0.0
     */
    @Test
    public void testTermFrequencyEmptyHashTable() {
        HashDocument emptyDoc = new HashDocument("Empty", "");
        assertEquals(0.0, emptyDoc.termFrequency("bye"), 0.001);
    }
}
