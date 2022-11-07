package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.STRIKE;

public class Referee {
    public static Map<String, Integer> createRefereeCount(List<Integer> baseballNumberList, List<Integer> inputNumberList) {
        Map<String, Integer> count = new HashMap<>(){{
            put(STRIKE.toString(),0);
            put(BALL.toString(),0);
        }};

        for (int i = 0; i < baseballNumberList.size(); i++) {
            int baseballNumber = baseballNumberList.get(i);
            int inputNumber = inputNumberList.get(i);
            addStrike(count, baseballNumber, inputNumber);
            addBall(baseballNumberList,count,baseballNumber,inputNumber);
        }
        return count;
    }
    private static void addBall(List<Integer> baseballNumberList, Map<String, Integer> ballCount, int answer, int input) {
        if(answer != input && baseballNumberList.contains(input)){
            ballCount.put(BALL.toString(), ballCount.get(BALL.toString()) + 1);
        }
    }
    private static void addStrike(Map<String, Integer> strikeCount, int answer, int input) {
        if(answer == input){
            strikeCount.put(STRIKE.toString(), strikeCount.get(STRIKE.toString()) + 1);
        }
    }

    public static String refereeAnswer(Integer ballCount, Integer strikeCount) {
        if(ballCount > 0 && strikeCount > 0){
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        if(ballCount > 0){
            return ballCount + "볼";
        }
        if(strikeCount > 0){
            return strikeCount + "스트라이크";
        }
        return "낫싱";
    }

}
