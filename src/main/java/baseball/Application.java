package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        while (true) {
            List<Integer> computer = initializeGame();

        }
    }

    private static List<Integer> initializeGame() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");

        return selectRandomNumbers();
    }
    private static List<Integer> selectRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> getPlayerInput() {
        String input = Console.readLine();
        List<Integer> player = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            player.add(input.charAt(i) - '0');
        }

        return player;
    }

    static int countStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                strike += 1;
            }
        }

        return strike;
    }
}