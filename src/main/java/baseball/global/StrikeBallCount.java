package baseball.global;

import java.util.HashMap;
import java.util.Map;

public class StrikeBallCount {

    public Map<String, Integer> init() {
        return new HashMap<>() {{
            put("Strike", 0);
            put("Ball", 0);
        }};
    }
}
