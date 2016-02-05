import static org.junit.Assert.*;

import org.junit.Test;

public class ReaderTest {
    public boolean equalNouns(Noun A, Noun B)
    {
        return A.latin.equals(B.latin) && A.english.equals(B.english)
                && A.singularGenitive.equals(B.singularGenitive) && A.gender.equals(B.gender);
    }

    @Test
    public void testcreatePartOfSpeech()
    {
        Noun A = (Noun) Reader.createPartOfSpeech("n.", "agricola    agricolae    f.   'farmer'"); // Basic functionality
        Noun B = new Noun("agricola", "agricolae", "f.", "farmer");
        assertTrue(equalNouns(A, B));

        B = (Noun) Reader.createPartOfSpeech("n.", "agricola agricolae f. 'farmer'");              // Ensures that the program can
        assertTrue(equalNouns(A, B));                                                                          // properly split up spaces
    }

    @Test
    public void testcreateVerb()
    {
        Verb A = Reader.createVerb("ambulo-   ambula-re  ambula-vi- ambulatum 'walk'");
        Verb B = new Verb("ambulo-", "ambula-re", "ambula-vi-", "ambula-tum", "walk");
        assertEquals(A.infinitive, B.infinitive);
    }
}
