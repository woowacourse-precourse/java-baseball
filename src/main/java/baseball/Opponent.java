package baseball;

import java.util.List;

public interface Opponent {

    List<Integer> createValue();
    public Hint getHint(List<Integer> inputValue);
}
