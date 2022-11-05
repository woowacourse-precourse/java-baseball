package baseball;

import java.util.List;

public interface Opponent {

    List<Integer> createAnswer();
    public Hint getHint(List<Integer> inputValue);
}
