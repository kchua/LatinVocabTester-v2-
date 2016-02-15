public class VocabFile {
    protected Noun[] nounsList;
    protected Verb[] verbsList;
    // Add other parts of speech

    public VocabFile(String fileName)
    {
        partsOfSpeech[] temp = Reader.readFile(fileName);
        nounsList = (Noun[]) filter(temp, "noun");
    }

    public static partsOfSpeech[] filter(partsOfSpeech[] vocabArray, String speechPart)
    {
        partsOfSpeech[] speechPartArray = new Noun[count(vocabArray, speechPart)];
        int ind = 0;
        for (int i = 0; i < vocabArray.length; i++)
        {
            if (speechPart.equals(identify(vocabArray[i])))
            {
                speechPartArray[ind++] = vocabArray[i];
            }
        }
        return speechPartArray;
    }

    public static int count(partsOfSpeech[] vocabArray, String speechPart)
    {
        int count = 0;
        for (int i = 0; i < vocabArray.length; i++)
        {
            if (speechPart.equals(identify(vocabArray[i])))
            {
                count++;
            }
        }
        return count;
    }

    public static String identify(partsOfSpeech item)
    {
        if (item instanceof Noun)
        {
            return "noun";
        }
        return null;
    }

    public partsOfSpeech[] getattr(String array)
    {
        partsOfSpeech[] desired = null;
        switch (array)
        {
            case "nouns":
                desired = nounsList;
                break;
        }
        return desired;
    }
}
