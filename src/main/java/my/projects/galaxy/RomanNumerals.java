package my.projects.galaxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public class RomanNumerals implements Numerals {

  @SuppressWarnings("serial")
  private static HashMap<String, Long> VALUES = new HashMap<String, Long>() {
    {
      put("I", 1L);
      put("V", 5L);
      put("X", 10L);
      put("L", 50L);
      put("C", 100L);
      put("D", 500L);
      put("M", 1000L);
    }
  };

  @Override
  public Long compute(List<String> symbols) {
    Queue<Long> numbers = asQueue(toNumbers(symbols));
    Long result = 0L;
    while (!numbers.isEmpty()) {
      Long current = numbers.poll();
      Long next = defaultTo(0L, numbers.peek());
      if (current >= next) {
        result += current;
      } else {
        result += (next - current);
        numbers.poll();
      }
    }
    return result;
  }

  private List<Long> toNumbers(List<String> symbols) {
    return symbols.stream()
        .map(x -> toNumber(x))
        .collect(Collectors.toList());
  }

  private Long toNumber(String symbol) {
    return VALUES.getOrDefault(symbol, 0L);
  }

  private Long defaultTo(long defaultValue, Long element) {
    return Optional.ofNullable(element).orElse(defaultValue);
  }

  private Queue<Long> asQueue(Collection<Long> elements) {
    return new LinkedList<>(elements);
  }
}
