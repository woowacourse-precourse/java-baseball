package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintLine.startGamePrint();

        do {
            List<Integer> computerNumberList = Game.createComputerNumberList();
            tryOnceForAnswer(computerNumberList);

        } while (tryAgain());
        PrintLine.endGame();
    }

    private static void tryOnceForAnswer(List<Integer> computerNumberList) {
        while (true) {
            Map<String, Integer> scoreTable = Game.createScoreTable();
            List<Integer> userNumberList = inputUserNumber();

            Game.matchLists(userNumberList, computerNumberList, scoreTable);
            PrintLine.resultPrint(scoreTable);

            if (scoreTable.get("스트라이크") == 3) {
                PrintLine.afterAnswerPrint();
                break;
            }
        }
    }

    private static boolean tryAgain() {
        PrintLine.putRestartNumberPrint();
        String restartNumber = Console.readLine();
        Validation.validateRestartNumber(restartNumber);

        if (restartNumber.equals("1")) {
            return true;
        }
        return false;
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
}
