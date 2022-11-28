package baseball.utils;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<Integer> generate();
}
