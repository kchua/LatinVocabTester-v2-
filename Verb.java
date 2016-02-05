import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verb extends partsOfSpeech {
    private String firstPersonPresent;
    private String infinitive;
    private String firstPersonPast;
    private String participle;

    private static final Pattern firstConjugation = Pattern.compile("(.*)a-re$");
    private static final Pattern secondConjugation = Pattern.compile("(.*)e-re$");
    private static final Pattern thirdConjugation = Pattern.compile("(.*)ere$");
    private static final Pattern fourthConjugation = Pattern.compile("(.*)ire$");

    public Verb(String firstPersonPresent, String infinitive, String firstPersonPast, String participle)
    {
        this.firstPersonPresent = firstPersonPresent;
        this.infinitive = infinitive;
        this.firstPersonPast = firstPersonPast;
        this.participle = participle;
    }

    public String getattr(String aspect)
    {
        String desired = "";
        switch (aspect)
        {
            case "firstPersonPresent":
                desired = firstPersonPresent;
                break;
            case "infinitive":
                desired = infinitive;
                break;
            case "firstPersonPast":
                desired = firstPersonPast;
                break;
            case "participle":
                desired = participle;
                break;
        }
        return desired;
    }

    public boolean test(String aspect, String answer)
  {
    return getattr(aspect) == answer;
  }
}
