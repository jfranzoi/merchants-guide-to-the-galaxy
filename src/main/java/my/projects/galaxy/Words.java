package my.projects.galaxy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Words {

    private final Map<String, Long> numbersByWord = new HashMap<String, Long>();

    public Words meaning(String word, String value) {
	numbersByWord.put(word, toNumber(value));
	return this;
    }

    public Long compute(String... words) {
	return Stream.of(words).map(x -> numberFor(x)).reduce(0L, (x, y) -> compute(x, y));
    }

    @Override
    public String toString() {
        return new StringBuilder().append("values by word: ").append("[").append(numbersByWord).append("]").toString();
    }

    private Long compute(Long left, Long right) {
	return right + (left * 10);
    }

    private Long toNumber(String value) {
	return Long.valueOf(value);
    }

    private Long numberFor(String word) {
	return numbersByWord.get(word);
    }

}
