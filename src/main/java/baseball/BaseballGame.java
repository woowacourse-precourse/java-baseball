package baseball;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseballGame {

    private Computer computer;
    private User user;

    private BaseballGame(){
        computer = new Computer();
        user = new User();
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다 ");
        computer.pickRandomNumbersFrom1To9();

        List<Integer> usersPick = user.pickNumbers();

        Map<String, Integer> result = countBallAndStrike(computer.getComputersPick(), usersPick);
    }

    public Map<String, Integer> countBallAndStrike(List<Integer> computersPick, List<Integer> usersPick) {
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
}
