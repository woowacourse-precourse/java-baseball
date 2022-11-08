package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String RESTART = "1";

    public static void startOfGame() {
        PrintLine.startGamePrint();
    }

    public static void endOfGame() {
        PrintLine.endGamePrint();
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

    public static void tryOnceForAnswer(List<Integer> computerNumberList) {

        while (true) {
            Map<String, Integer> scoreTable = createScoreTable();
            List<Integer> userNumberList = inputUserNumber();
            matchLists(userNumberList, computerNumberList, scoreTable);
            PrintLine.resultPrint(scoreTable, STRIKE, BALL);

            if (scoreTable.get(STRIKE) == 3) {
                PrintLine.afterAnswerPrint();
                break;
            }
        }
    }

    public static boolean tryAgainGame() {
        String restartNumber = inputRestartNumber();
        return restartNumber.equals(RESTART);
    }

    private static String inputRestartNumber() {
        PrintLine.putRestartNumberPrint();
        String restartNumber = Console.readLine();
        Validation.validateRestartNumber(restartNumber);
        return restartNumber;
    }

    private static List<Integer> inputUserNumber() {
        PrintLine.putUserNumberPrint();
        String userNumber = Console.readLine();
        Validation.validateUserNumber(userNumber);
        return stringToIntegerList(userNumber);
    }

    private static List<Integer> stringToIntegerList(String numbers) {
        String[] arr = numbers.split("");
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static Map<String, Integer> createScoreTable() {
        Map<String, Integer> scoreTable = new HashMap<>();
        scoreTable.put(STRIKE, 0);
        scoreTable.put(BALL, 0);

        return scoreTable;
    }

    private static void matchLists(List<Integer> userNumberList, List<Integer> computerNumberList, Map<String, Integer> scoreTable) {
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
