import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Noun extends partsOfSpeech {
  private String latin;
  private String singularGenitive;
  private String gender;
  private String english;

  private static final Pattern firstDeclension = Pattern.compile("(.*)ae$");
  // Add other declension patterns below.

  public Noun(String latin, String singularGenitive, String gender, String english)
  {
    this.latin = latin;
    this.singularGenitive = singularGenitive;
    this.gender = gender;
    this.english = english;
  }

  public String getattr(String aspect)
  {
    String desired = "";
    switch (aspect)
    {
      case "latin":
        desired = latin;
        break;
      case "singularGenitive":
        desired = singularGenitive;
        break;
      case "gender":
        desired = gender;
        break;
      case "english":
        desired = english;
        break;
    }
    return desired;
  }

  public boolean test(String aspect, String answer)
  {
    return getattr(aspect) == answer;
  }

  public String toString()
  {
    return latin + ", " + singularGenitive + " ("+ gender + ")  -  " + english;
  }

  /* Identifies the declension of a noun and prints it in the indicated case.
  Note: does not yet consider irregular forms */
  public static void decline(Noun n, String nouncase)
  {
    switch (declension(n))
    {
      case 0:
        System.out.println("Not yet implemented");
      case 1:
        System.out.println(declineFirst(n, nouncase));
      // Add cases for the other declensions
    }
  }

  /* Identifies the declension of a noun by returning a number between 1 and 5. */
  private static int declension(Noun n)
  {
    if (firstDeclension.matcher(n.singularGenitive).find())
    {
      return 1;
    }
    // Add other cases here for other declensions
    return 0;
  }

  /* Takes a first declension noun and returns it in the indicated case */
  private static String declineFirst(Noun n, String nouncase)
  {
    Matcher m = firstDeclension.matcher(n.singularGenitive);
    m.find();
    String stem = m.group(1);
    String declined = null;
    switch (nouncase)
    {
      case "Singular Nominative":
        declined = n.latin;
        break;
      case "Singular Genitive":
        declined = n.singularGenitive;
        break;
      case "Singular Dative":
        declined = stem + "ae";
        break;
      case "Singular Accusative":
        declined = stem + "am";
        break;
      case "Singular Ablative":
        declined = stem + "a-";
        break;
      case "Singular Vocative":
        declined = n.latin;
        break;

      case "Plural Nominative":
        declined = stem + "ae";
        break;
      case "Plural Genitive":
        declined = stem + "a-rum";
        break;
      case "Plural Dative":
        declined = stem + "i-s";
        break;
      case "Plural Accusative":
        declined = stem + "a-s";
        break;
      case "Plural Ablative":
        declined = stem + "i-s";
        break;
      case "Plural Vocative":
        declined = stem + "ae";
        break;
    }
    return declined;
  }
}
