package baseball.domain.number;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    public List<Integer> generate();
}
