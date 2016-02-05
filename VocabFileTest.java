import static org.junit.Assert.*;

import org.junit.Test;

public class VocabFileTest {
    @Test
    public void testsort()
    {
        partsOfSpeech[] A = Reader.readFile("test.txt");
        assertEquals(VocabFile.count(A, "noun"), 33);

        partsOfSpeech[] B = Reader.readFile("test2.txt");
        assertEquals(VocabFile.count(B, "verb"), 6);
        assertEquals(VocabFile.count(B, "noun"), 9);
    }
}
