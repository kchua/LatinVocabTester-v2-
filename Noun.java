public class Noun extends partsOfSpeech {
  private String latin;
  private String singularGenitive;
  private String gender;
  private String english;

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
}
