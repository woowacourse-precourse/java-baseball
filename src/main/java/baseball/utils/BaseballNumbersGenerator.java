package baseball.utils;

import java.util.List;

@FunctionalInterface
public interface BaseballNumbersGenerator {

    List<Integer> generate();
}
