package baseball;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {

    private static Map<String, Integer> strikeAndBallCounter;
    public static void main(String[] args) {
        initializerOfStrikeAndBallCounter();

    }

    static void initializerOfStrikeAndBallCounter() {
        strikeAndBallCounter = new LinkedHashMap<>();
        strikeAndBallCounter.put("strike", 0);
        strikeAndBallCounter.put("ball", 0);
    }
}
