package baseball;

import java.util.HashMap;
import java.util.Map;

import static baseball.Application.StringConst.*;

public class Application {
    public static void main(String[] args) {
    }

    public static void printScore(Map<String, Integer> score) {
        Integer ballCount = score.get(BALL);
        Integer strikeCount = score.get(STRIKE);

        if (!ballCount.equals(0))
            System.out.print(ballCount + BALL);
        if (!strikeCount.equals(0))
            System.out.print(" " + strikeCount + STRIKE);
        if (ballCount.equals(0) && strikeCount.equals(0))
            System.out.print(NOTHING);
        System.out.print("\n");
    }

    public static Map<String, Integer> score(Integer computerNumber, Integer userNumber) {
        Map<String, Integer> ret = new HashMap<>();
        ret.put(STRIKE, 0);
        ret.put(BALL, 0);
        String computerNumberStringType = String.valueOf(computerNumber);
        char[] computerPlaceValues = computerNumberStringType.toCharArray();
        char[] userPlaceValues = String.valueOf(userNumber).toCharArray();

        for (int i = 0; i < 3; ++i)
            if (computerNumberStringType.contains(String.valueOf(userPlaceValues[i])))
                ret.put(BALL, ret.get(BALL) + 1);
        for (int i = 0; i < 3; ++i)
            if (userPlaceValues[i] == computerPlaceValues[i]) {
                ret.put(STRIKE, ret.get(STRIKE) + 1);
                ret.put(BALL, ret.get(BALL) - 1);
            }

        return ret;
    }

    interface StringConst {
        String BALL = "볼";
        String STRIKE = "스트라이크";
        String NOTHING = "낫싱";
    }
}
