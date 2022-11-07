package baseball;

import java.util.List;

import static baseball.Constants.*;
import static baseball.Functions.*;
import static baseball.UserInput.*;

public class Game {
    public static void start() {
        System.out.println(BEGIN_MESSAGE);
        do {
            play();
            System.out.println(END_MESSAGE);
        } while (askContinue());
    }

    private static void play() {
        //랜덤숫자 생성
        List<Integer> targetNums = createTargetNums();
        mainGame(targetNums);
    }

    private static void mainGame(List<Integer> targetNums) {
        while (true) {
            List<Integer> userNums = stringToIntegerList(numberInput());
            List<Integer> ball_Strike = count_BallStrike(targetNums, userNums);
            printResult(ball_Strike);
            if (isFullhit(ball_Strike))
                break;
        }
    }

    private static boolean askContinue() {
        System.out.println(CONT_MESSAGE);
        String input = continueInput();
        if (input.equals(CONTINUE)) {
            return true;
        }
        return false;
    }
}
