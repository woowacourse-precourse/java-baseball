package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHost extends BaseballNumber {
    private Map<String, Integer> hint = new HashMap<>();

    public Map<String, Integer> getHint(List<Integer> playerNumber) {
        return hint;
    }

    public void setHint(List<Integer> playerNumber) {
    }
}
