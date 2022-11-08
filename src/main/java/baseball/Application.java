package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintLine.startGamePrint();

        String restartNumber;

        do {
            List<Integer> computerNumberList = Game.createComputerNumberList();
            while (true) {
                Map<String, Integer> scoreTable = Game.createScoreTable();
                PrintLine.putUserNumberPrint();
                String userNumber = Console.readLine();
                Validation.validateUserNumber(userNumber);
                List<Integer> userNumberList = stringToIntegerList(userNumber);

                Game.matchLists(userNumberList, computerNumberList, scoreTable);
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
}
