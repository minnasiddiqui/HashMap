import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class is the test class for WordFrequency class.
 * It tests the methods of the WordFrequency class.
 * It tests the constructor, getter methods, increment method and compareTo method.
 */
public class WordFrequencyTest {
    // Object to be tested
    private WordFrequency runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new WordFrequency("Hello");
    }

    /**
     * Tests the getWord method.
     * should return the word
     */
    @Test
    public void testGetWord() {
        assertEquals("Hello", runner.getWord());
    }
    /**
     * Tests the getCount method.
     * should returns the count of the word
     */
    @Test
    public void testGetCount() {
        assertEquals(1, runner.getCount());
    }
    /**
     * Tests the increment method.
     * should increase the count by 1
     */
    @Test
    public void testIncrement() {
        runner.increment();
        assertEquals(2, runner.getCount());
    }
    /**
     * Tests the compareTo method.
     * should return 0 if the words are the same, etc.
     */
    @Test
    public void testCompareTo() {
        WordFrequency wf1 = new WordFrequency("apple");
        WordFrequency wf2 = new WordFrequency("banana");
        WordFrequency wf3 = new WordFrequency("apple");
        wf3.increment();
        assertTrue(wf1.compareTo(wf2) < 0);
        assertTrue(wf2.compareTo(wf1) > 0);
        assertTrue(wf1.compareTo(wf3) < 0);
        assertTrue(wf3.compareTo(wf1) > 0);
        assertEquals(0, wf1.compareTo(new WordFrequency("apple")));
    }
}