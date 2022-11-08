package baseball;

import java.util.*;

public class Controller {

    private static Map<String, Integer> scoreMap = new HashMap<>();
    private static List<Integer> computerNumberList;
    private static List<Integer> playerNumberList;

    public static Map<String, Integer> calcScore(Computer computer, Player player) {
        computerNumberList = computer.getComputer();
        playerNumberList = player.getPlayer();

        scoreMap.clear();

        calcStrike();
        calcBall();
        calcNothing();

        validateNothing();
        validateScoreCount();

        return scoreMap;
    }

    public static void calcNothing() {
        Set<String> keySet = scoreMap.keySet();
        if (keySet.size() == 0) {
            increaseScore(Application.NOTHING);
        }
    }

    public static void calcStrike() {
        for (int i = 0; i < Application.LENGTH; i++) {
            if (playerNumberList.get(i).equals(computerNumberList.get(i))) {
                increaseScore(Application.STRIKE);
            }
        }
    }

    public static void calcBall() {
        for (Integer computerNumber : computerNumberList) {
            if (playerNumberList.contains(computerNumber) &&
                    playerNumberList.indexOf(computerNumber) != computerNumberList.indexOf(computerNumber)) {
                increaseScore(Application.BALL);
            }
        }
    }


    public static void increaseScore(String key) {
        if (scoreMap.containsKey(key)) {
            Integer score = scoreMap.get(key);
            scoreMap.put(key, score + 1);
        } else {
            scoreMap.put(key, 1);
        }

    }

    public static void validateScoreCount() {
        Set<String> keySet = scoreMap.keySet();
        Iterator<String> it = keySet.iterator();

        while (it.hasNext()) {
            String key = it.next();
            Integer value = scoreMap.get(key);
            if (value > Application.LENGTH) {
                throw new IllegalArgumentException(key + "의 카운트는 최대 + " + Application.LENGTH + "입니다.");
            }
        }
    }

    public static void validateNothing() {
        Set<String> keySet = scoreMap.keySet();
        if (keySet.size() > 1 && keySet.contains(Application.NOTHING)) {
            throw new IllegalArgumentException(Application.NOTHING + "이면서 다른 결과값도 가지고 있습니다.");
        }
    }

    // 테스트 코드에서 사용할 목적
    public static Map<String, Integer> getScoreMap() {
        return scoreMap;
    }

    // 테스트 코드에서 사용할 목적
    public static void clearScoreMap() {
        scoreMap.clear();
    }
}
