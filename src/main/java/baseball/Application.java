package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintLine.startGamePrint();

        String restartNumber;

        do {
            List<Integer> computerNumberList = createComputerNumberList();
            while (true) {
                Map<String, Integer> scoreTable = createScoreTable();
                PrintLine.putUserNumberPrint();
                String userNumber = Console.readLine();
                Validation.validateUserNumber(userNumber);
                List<Integer> userNumberList = stringToIntegerList(userNumber);

                matchLists(userNumberList, computerNumberList, scoreTable);
                PrintLine.resultPrint(scoreTable);

                if (scoreTable.get("스트라이크") == 3) {
                    PrintLine.afterAnswerPrint();
                    break;
                }
            }

            PrintLine.putRestartNumberPrint();
            restartNumber = Console.readLine();
            Validation.validateRestartNumber(restartNumber);
        } while (restartNumber.equals("1"));
        PrintLine.endGame();
    }

    private static List<Integer> stringToIntegerList(String numbers) {
        String[] arr = numbers.split("");
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
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
            scoreTable.put("스트라이크", scoreTable.get("스트라이크") + 1);
            return;
        }
        scoreTable.put("볼", scoreTable.get("볼") + 1);
    }

    private static Map<String, Integer> createScoreTable() {
        Map<String, Integer> scoreTable = new HashMap<>();
        scoreTable.put("스트라이크", 0);
        scoreTable.put("볼", 0);

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
}
