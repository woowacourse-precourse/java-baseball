package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseballGame {

    private Computer computer;
    private User user;
    private boolean gameOver;

    BaseballGame(){
        computer = new Computer();
        user = new User();
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다 ");
        computer.pickRandomNumbersFrom1To9();
        gameOver = false;

        while (!gameOver){
            try {
                List<Integer> usersPick = user.pickNumbers();
                Map<String, Integer> result = countBallsAndStrikes(computer.getComputersPick(), usersPick);
                printResult(result);
                gameOverIfThreeStrike(result);

            }catch (IllegalArgumentException exception) {
                throw exception;
            }
        }
    }

    public Map<String, Integer> countBallsAndStrikes(List<Integer> computersPick, List<Integer> usersPick) {
        Map<String, Integer> counts = new TreeMap<>();

        for (int i = 0; i < computersPick.size(); i++) {
            if (computersPick.get(i).equals(usersPick.get(i))) {
                counts.put("스트라이크", counts.getOrDefault("스트라이크", 0) + 1);
                continue;
            }
            if (computersPick.contains(usersPick.get(i))) {
                counts.put("볼", counts.getOrDefault("볼", 0) + 1);
            }
        }

        return counts;
    }

    private void printResult(Map<String, Integer> result) {
        if (result.isEmpty()) {
            System.out.println("낫싱");
            return;
        }

        List<String> results = new ArrayList<>();
        for (String key: result.keySet()) {
            results.add(result.get(key) + key);
        }
        String resultToString = String.join(" ", results);
        System.out.println(resultToString);
    }

    private void gameOverIfThreeStrike(Map<String, Integer> result){
        if (result.getOrDefault("스트라이크", 0) == 3) {
            gameOver = true;
        }
    }
}
