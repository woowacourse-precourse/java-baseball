package baseball.generator;

import java.util.List;

@FunctionalInterface
public interface NumbersGenerator {

    List<Integer> generate();
}
