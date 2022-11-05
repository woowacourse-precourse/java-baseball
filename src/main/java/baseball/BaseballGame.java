package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame {
    public void start() {
        while (true) {
            System.out.println(START_GAME);

            List<Integer> computer = makeAnswer();

            if (playBaseballGame(computer)) {
                break;
            }
        }
    }

    private boolean playBaseballGame(List<Integer> answer) {
        while (true) {
            String result;
            System.out.print(INPUT_NUMBER);
            String input = Console.readLine();
            List<Integer> user = makeUserAnswer(input);

            result = playMatch(answer, user);
            System.out.println(result);

            if (result.equals(END_GAME_CONDITION)) {
                return restart();
            }
        }
    }

    private static boolean restart() {
        System.out.println(RESTART_CONDITION);
        String restartInput = Console.readLine();
        if (restartInput.equals(INPUT_END)) {
            return true;
        }
        if (restartInput.equals(INPUT_START)) {
            return false;
        }
        throw new IllegalArgumentException(INPUT_RESTART_EXCEPTION);
    }

    private static String playMatch(List<Integer> computer, List<Integer> user) {
        int strike = ZERO;
        int ball = ZERO;
        for (int i = 0; i < user.size(); i++) {
            strike = strike(computer, user, strike, i);
            ball = ball(computer, user, ball, i);
        }

        return makeResult(strike, ball);
    }

    private static String makeResult(int strike, int ball) {
        if (ball == ZERO && strike == ZERO) {
            return NOTHING;
        }
        return ballOrStrike(strike, ball);
    }

    private static String ballOrStrike(int strike, int ball) {
        if (strike == ZERO) {
            return ball + BALL;
        }
        if (ball == ZERO) {
            return checkEndCondition(strike);
        }
        return ball + BALL + " " + strike + STRIKE;
    }

    private static String checkEndCondition(int strike) {
        if (strike == END_GAME_STRIKE_CONDITION) {
            return END_GAME_CONDITION;
        }
        return strike + STRIKE;
    }

    private static int ball(List<Integer> computer, List<Integer> user, int ball, int i) {
        if (computer.contains(user.get(i)) && !Objects.equals(computer.get(i), user.get(i))) {
            ball++;
        }
        return ball;
    }

    private static int strike(List<Integer> computer, List<Integer> user, int strike, int i) {
        if (computer.contains(user.get(i)) && Objects.equals(computer.get(i), user.get(i))) {
            strike++;
        }
        return strike;
    }

    private List<Integer> makeUserAnswer(String input) {
        try {
            validateThree(input.length(), INPUT_LENGTH_EXCEPTION);
            List<Integer> user = makeUserList(input);
            validateThree(user.size(), INPUT_OTHER_NUMBER_EXCEPTION);
            return user;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static List<Integer> makeUserList(String input) {
        List<Integer> list = new ArrayList<>();
        for (String number : input.split("")) {
            addBall(list, Integer.parseInt(number));
        }
        return list;
    }

    private void validateThree(int number, String message) {
        if (isDefaultSize(number)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean isDefaultSize(int number) {
        return number != DEFAULT_SIZE;
    }

    private static List<Integer> makeAnswer() {
        List<Integer> list = new ArrayList<>();
        while (isDefaultSize(list.size())) {
            addBall(list, Randoms.pickNumberInRange(1, 9));
        }
        return list;
    }

    private static void addBall(List<Integer> list, int ballNumber) {
        validateRangeOfBall(ballNumber);
        if (!list.contains(ballNumber)) {
            list.add(ballNumber);
        }
    }

    private static void validateRangeOfBall(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(RANGE_OF_BALL_EXCEPTION);
        }
    }
}
