package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player computer = createPlayer(NumberUtil.random());
        Player user = createPlayer(NumberUtil.input());
        if (!user.isPossiblePlay()) {
            throw new IllegalArgumentException();
        }
        GameResult gameResult = play(computer, user);
        gameResult.printResult();
    }

    public static Player createPlayer(List<Integer> numbers) {
        return new Player(numbers);
    }

    public static GameResult play(Player computer, Player user) {
        GameResult gameResult = new GameResult();

        HashMap<Integer, List<Integer>> ordersMap = new HashMap<>();
        List<Integer> comNumbers = computer.getNumbers();
        List<Integer> usrNumbers = user.getNumbers();

        // 숫자를 key로 지정하고 등장하는 순서를 맵에 저장한다.
        // 예: hashMap[3] -> [2,2]
        // 숫자 3은 computer의 2번째 숫자이고 user의 2번째 숫자이다. -> 스트라이크
        for (int index = 0; index < NumberUtil.NUMBER_SIZE; index++) {
            ordersMap.computeIfAbsent(comNumbers.get(index), k -> new ArrayList<>()).add(index);
            ordersMap.computeIfAbsent(usrNumbers.get(index), k -> new ArrayList<>()).add(index);
        }

        for (List<Integer> orders : ordersMap.values()) {
            if (orders.size() < 2) {
                continue;
            }
            if (orders.get(0) == orders.get(1)) {
                gameResult.addStrike();
            } else {
                gameResult.addBall();
            }
        }

        return gameResult;
    }
}
