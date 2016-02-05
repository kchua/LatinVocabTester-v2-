import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Reader {
    private static final String nounPattern =
      "(\\S*)\\s+(\\S*)\\s+(\\S*)\\s+'([\\S\\s]+)'";
    // Add other patterns here

    // Reads a file and returns an array of vocabulary words
    public static partsOfSpeech[] readFile(String fileName)
    {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }

        partsOfSpeech[] vocabArray = new partsOfSpeech[sc.nextInt()];
        int i = 0;
        while (i < vocabArray.length)
        {
            vocabArray[i] = createPartOfSpeech(sc.next(), sc.nextLine());
            i++;
        }
        return vocabArray;
    }

    // Takes in a string definition, classifies it, and returns an object that
    // corresponds to the part of speech being defined.
    public static partsOfSpeech createPartOfSpeech(String type, String definition)
    {
        partsOfSpeech word = null;
        switch (type)
        {
            case "n.":
                word =  createNoun(definition);
                break;
            // Add other parts of speech as cases below as required.
        }
        return word;
    }

    // Creates a noun from a string definition
    public static Noun createNoun(String definition)
    {
        Pattern r = Pattern.compile(nounPattern);
        Matcher m = r.matcher(definition);
        m.find();
        return new Noun(m.group(1), m.group(2), m.group(3), m.group(4));
    }
}
