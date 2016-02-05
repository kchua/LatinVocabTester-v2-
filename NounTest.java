import static org.junit.Assert.*;

import org.junit.Test;

public class NounTest {
    @Test
    public void testdeclension()
    {
        Noun A = new Noun("agricola", "agricolae", "f.", "farmer");     // First declension noun
        assertEquals(Noun.declension(A), 1);

        A = new Noun("agricolae", "agricola", "f.", "farmer");          // Not an actual noun, does not belong to any declension
        assertEquals(Noun.declension(A), 0);
    }

    @Test
    public void testdeclineFirst()
    {
        Noun A = new Noun("agricola", "agricolae", "f.", "farmer");
        assertEquals(Noun.declineFirst(A, "Singular Dative"), "agricolae");
        assertEquals(Noun.declineFirst(A, "Plural Genitive"), "agricola-rum");
    }

    /*
    public static void main(String[] args)
    {
        String aspect1 = "latin";
        String aspect2 = "singularGenitive";

        String latin = "agricola";
        String singularGenitive = "agricolae";
        String gender = "m";
        String definition = "farmer";

        Noun agricola = new Noun("agricola", "agricolae", "m", "farmer");

        System.out.println(agricola.test(aspect2, singularGenitive));
        System.out.println(agricola.test(aspect1, latin));
        System.out.println(agricola.test(aspect2, latin));
        System.out.println(agricola);

        String singular[] = new String[]{"Singular Nominative","Singular Genitive","Singular Dative","Singular Accusative","Singular Ablative","Singular Vocative"};

        String plural[] = new String[]{"Plural Nominative","Plural Genitive","Plural Dative","Plural Accusative","Plural Ablative","Plural Vocative"};

        for(int i=0; i < singular.length; i++)
        {
            System.out.print(singular[i] + "   ");
            Noun.decline(agricola, singular[i]);
        }
        for(int i=0; i < plural.length; i++)
        {
            System.out.print(plural[i] + "   ");
            Noun.decline(agricola, plural[i]);
        }
    }
    */
}
