public class Noun {
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

  public String getLatin()
  {
    return latin;
  }

  public String getSingularGenitive()
  {
    return singularGenitive;
  }

  public String getGender()
  {
    return gender;
  }

  public String getEnglish()
  {
    return english;
  }

  public String getattr(String aspect)
  {
    String desired = "";
    switch (aspect)
    {
      case "latin":
        desired = getLatin();
        break;
      case "singularGenitive":
        desired = getSingularGenitive();
        break;
      case "gender":
        desired = getGender();
        break;
      case "english":
        desired = getEnglish();
        break;
    }
    return desired;
  }

  public boolean test(String aspect, String answer)
  {
    return getattr(aspect) == answer;
  }
}
