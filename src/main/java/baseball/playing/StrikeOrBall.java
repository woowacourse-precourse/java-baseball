package baseball.playing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrikeOrBall {

    private List<Integer> stringToList(String number) {
        List<Integer> numbers = new ArrayList<>();
        for (char num : number.toCharArray()) {
            numbers.add(Character.getNumericValue(num));
        }

        return numbers;
    }

    public String printStrikeOrBall(String computerNumber, String userNumber) {

        Map<String, Integer> strikeBall = checkStrikeOrBall(computerNumber, userNumber);

        if (strikeBall.get("Strike") == 0 && strikeBall.get("Ball") != 0) {
            return strikeBall.get("Ball") + "볼";
        } else if (strikeBall.get("Ball") == 0 && strikeBall.get("Strike") != 0) {
            return strikeBall.get("Strike") + "스트라이크";
        } else if (strikeBall.get("Strike") == 0 && strikeBall.get("Ball") == 0) {
            return "낫싱";
        }

        return strikeBall.get("Ball") + "볼 " + strikeBall.get("Strike") + "스트라이크";
    }

    public Map<String, Integer> checkStrikeOrBall(String computerNumber, String userNumber) {

        List<Integer> computerNumberList = stringToList(computerNumber);
        List<Integer> userNumberList = stringToList(userNumber);

        Map<String, Integer> strikeBall = new HashMap<>();

        strikeBall.put("Strike", Strike(computerNumberList, userNumberList));
        strikeBall.put("Ball", Ball(computerNumberList, userNumberList));

        return strikeBall;
    }

    private int Strike(List<Integer> computerNumberList, List<Integer> userNumberList) {

        int numberSize = 3;
        int strike = 0;

        for (int i = 0; i < numberSize; i++) {
            if (computerNumberList.get(i) == userNumberList.get(i))
                strike++;
        }

        return strike;
    }

    private int Ball(List<Integer> computerNumberList, List<Integer> userNumberList) {

        int numberSize = 3;
        int ball = 0;

        for (int i = 0; i < numberSize; i++) {
            if (!(computerNumberList.get(i) == userNumberList.get(i))
                    && computerNumberList.contains(userNumberList.get(i)))
                ball++;
        }

        return ball;
    }
}
