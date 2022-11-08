package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";


    public static Map<String, Integer> createScoreTable() {
        Map<String, Integer> scoreTable = new HashMap<>();
        scoreTable.put(STRIKE, 0);
        scoreTable.put(BALL, 0);

        return scoreTable;
    }

    public static List<Integer> createComputerNumberList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    public static void matchLists(List<Integer> userNumberList, List<Integer> computerNumberList, Map<String, Integer> scoreTable) {
        for (Integer userNumber : userNumberList) {
            matchingNumbers(userNumberList, computerNumberList, scoreTable, userNumber);
        }
    }

    private static void matchingNumbers(List<Integer> userNumberList, List<Integer> computerNumberList, Map<String, Integer> scoreTable, Integer userNumber) {
        if (computerNumberList.contains(userNumber)) {
            checkStrike(userNumberList, computerNumberList, scoreTable, userNumber);
        }
    }

    private static void checkStrike(List<Integer> userNumberList, List<Integer> computerNumberList, Map<String, Integer> scoreTable, Integer userNumber) {
        if (userNumberList.indexOf(userNumber) == computerNumberList.indexOf(userNumber)) {
            scoreTable.put(STRIKE, scoreTable.get(STRIKE) + 1);
            return;
        }
        scoreTable.put(BALL, scoreTable.get(BALL) + 1);
    }
}
