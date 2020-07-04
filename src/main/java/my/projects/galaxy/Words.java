package my.projects.galaxy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Words {

    private final Map<String, Integer> valuesByWord = new HashMap<String, Integer>();

    public Words meaning(String word, String value) {
	valuesByWord.put(word, Integer.valueOf(value));
	return this;
    }

    public Integer compute(String... words) {
	return Stream.of(words).map(x -> toValue(x)).reduce(0, (x, y) -> compute(x, y));
    }

    private Integer compute(Integer one, Integer another) {
	return another + (one * 10);
    }

    private Integer toValue(String word) {
	return valuesByWord.getOrDefault(word, 0);
    }

    @Override
    public String toString() {
	return new StringBuilder().append("values by word: ").append("[").append(valuesByWord).append("]").toString();
    }

}
