package my.projects.galaxy;

public interface Translations {

  Translations meaning(String word, String symbol);

  Long compute(String... words);

}