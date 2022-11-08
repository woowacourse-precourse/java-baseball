package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static baseball.Constant.*;

public class Computer {
    static int strike;
    static int ball;

    public static List<Integer> generateNumber() {
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }

    public static void countStrikeBall(List<Integer> computerAnswer, String playerAnswerStr) {
        List<Integer> playerAnswer = Player.stringToIntegerList(playerAnswerStr);
        strike = 0;
        ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerAnswer.get(i).equals(playerAnswer.get(i))) {
                strike++;
            } else if (computerAnswer.contains(playerAnswer.get(i))) {
                ball++;
            }
        }
    }

    public static boolean getResult() {
        if (strike == NUMBER_SIZE) {
            System.out.println(NUMBER_SIZE + STRIKE_MESSAGE);
            System.out.println(SUCCESS_MESSAGE);
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
            return false;
        } else {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            return false;
        }
    }

}
