package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    List<Integer> computer = new ArrayList<>();

    public Computer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumber() {
        return computer;
    }

    public String getRandomNumberToString() {
        String result = "";

        for (int i = 0; i < computer.size(); i++) {
            result += computer.get(i);
        }
        return result;
    }

    public List<Integer> calcHint(String playerInput, String computerInput) {
        int ballOfHint = 0;
        int strikeOfHint = 0;

        for (int i = 0; i < 3; i++) {
            if (computerInput.charAt(i) == playerInput.charAt(i)) {
                strikeOfHint += 1;
            } else if (computerInput.contains(Character.toString(playerInput.charAt(i)))) {
                ballOfHint += 1;
            }
        }

        return Arrays.asList(ballOfHint, strikeOfHint);
    }

    public String printHint(List<Integer> calcHintResult) {
        int strike = calcHintResult.get(1);
        int ball = calcHintResult.get(0);

        String result = "";

        if (strike == 0 && ball == 0) {
            result = "낫싱";
        } else if (strike == 3) {
            result = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strike > 0 && ball > 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (strike == 0) {
            result = ball + "볼";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        }

        return result;
    }
}
