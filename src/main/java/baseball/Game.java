package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    public static void startGame() {
        Output.startMessage();
        List<Integer> target = gameSet();
        while (true) {
            int num = Input.inputNumber();
            List<Integer> validNum = Validate.isNumValid(num);
            int[] score = getScore(target, validNum);
            if (Output.scoreMessage(score)) {
                return;
            }
        }
    }

    private static List<Integer> gameSet() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int[] getScore(List<Integer> target, List<Integer> num) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(target.get(i), num.get(i))) {
                strike += 1;
            } else if (target.contains(num.get(i))) {
                ball += 1;
            }
        }
        return new int[]{strike, ball};
    }
}
