package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseballGame {

    private Computer computer;
    private User user;
    private boolean gameOver;

    BaseballGame() {
        computer = new Computer();
        user = new User();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다 ");
        computer.pickRandomNumbersFrom1To9();
        gameOver = false;

        while (!gameOver) {
            try {
                List<Integer> usersPick = user.pickNumbers();
                Map<String, Integer> result = getResult(computer.getNumbers(), usersPick);
                printResult(result);
                gameOverIfThreeStrike(result);

            } catch (IllegalArgumentException exception) {
                throw exception;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        switch (Console.readLine()) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }

    public Map<String, Integer> getResult(List<Integer> computersPick, List<Integer> usersPick) {
        Map<String, Integer> counts = new TreeMap<>();

        counts.put("볼", countBalls(computersPick, usersPick));
        counts.put("스트라이크", countStrikes(computersPick, usersPick));

        return counts;
    }

    private int countBalls(List<Integer> computersPick, List<Integer> usersPick) {
        int count = 0;
        for (int i = 0; i < computersPick.size(); i++) {
            if (computersPick.get(i).equals(usersPick.get(i))) {
                continue;
            }
            if (computersPick.contains(usersPick.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    private int countStrikes(List<Integer> computersPick, List<Integer> usersPick) {
        int count = 0;
        for (int i = 0; i < computersPick.size(); i++) {
            if (computersPick.get(i).equals(usersPick.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    private void printResult(Map<String, Integer> result) {
        if (result.isEmpty()) {
            System.out.println("낫싱");
            return;
        }

        List<String> results = new ArrayList<>();
        for (String key : result.keySet()) {
            results.add(result.get(key) + key);
        }
        String resultToString = String.join(" ", results);
        System.out.println(resultToString);
    }

    private void gameOverIfThreeStrike(Map<String, Integer> result) {
        if (result.getOrDefault("스트라이크", 0) == 3) {
            gameOver = true;
        }
    }
}
