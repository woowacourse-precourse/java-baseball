package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        String restartNumber;

        do {
            List<Integer> computerNumberList = createComputerNumberList();
            while (true) {
                Map<String, Integer> scoreTable = createScoreTable();
                System.out.print("숫자를 입력해주세요 : ");
                String userNumber = Console.readLine();
                List<Integer> userNumberList = Validation.validateUserNumber(userNumber);


                matchLists(userNumberList, computerNumberList, scoreTable);
                printResult(scoreTable);

                if (scoreTable.get("스트라이크") == 3) {
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartNumber = Console.readLine();
            Validation.validateRestartNumber(restartNumber);
        } while (restartNumber.equals("1"));
    }

    private static void printResult(Map<String, Integer> scoreTable) {
        if (scoreTable.get("스트라이크") == 0 && scoreTable.get("볼") == 0) {
            System.out.print("낫싱");
        }
        if (scoreTable.get("볼") != 0) {
            System.out.print(scoreTable.get("볼") + "볼 ");
        }
        if (scoreTable.get("스트라이크") != 0) {
            System.out.print(scoreTable.get("스트라이크") + "스트라이크");
        }
        System.out.println();

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
