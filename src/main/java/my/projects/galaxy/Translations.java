package my.projects.galaxy;

public interface Translations {

  Translations meaning(String word, String value);

  Long compute(String... words);

}