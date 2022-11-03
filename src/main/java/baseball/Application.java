package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> playerNumber() {
        List<Integer> player = new ArrayList<>();
        String input = Console.readLine();

        while (player.size() < 3) {
            int idx = 0;
            char inputNumber = input.charAt(idx);
            int inputNumberToInt = inputNumber - '0';
            player.add(inputNumberToInt);
            idx++;
        }
        return player;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
