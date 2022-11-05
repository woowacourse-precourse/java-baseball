package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME_CONDITION = "3스트라이크\n"
            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_CONDITION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_LENGTH_EXCEPTION = "세자리 수를 입력해주세요";
    private static final String INPUT_OTHER_NUMBER_EXCEPTION = "각각 다른 수를 입력해주세요";
    private static final String INPUT_RESTART_EXCEPTION = "1 또는 2를 입력해주세요";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final int ZERO = 0;
    private static final String INPUT_START = "1";
    private static final String INPUT_END = "2";
    private static final int END_GAME_STRIKE_CONDITION = 3;
    private static final int DEFAULT_SIZE = 3;

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
            System.out.println(playMatch(answer, user));

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
            validThreeLengthOrSize(input.length(), INPUT_LENGTH_EXCEPTION);
            List<Integer> user = makeUserList(input);
            validThreeLengthOrSize(user.size(), INPUT_OTHER_NUMBER_EXCEPTION);
            return user;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static List<Integer> makeUserList(String input) {
        List<Integer> list = new ArrayList<>();
        for (String number : input.split("")) {
            addBall(list, Integer.parseInt(number));
        }
        return list;
    }

    private void validThreeLengthOrSize(int number, String message) {
        if (number != DEFAULT_SIZE) {
            throw new IllegalArgumentException(message);
        }
    }

    private static List<Integer> makeAnswer() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != DEFAULT_SIZE) {
            addBall(list, Randoms.pickNumberInRange(1, 9));
        }
        return list;
    }

    private static void addBall(List<Integer> list, int random) {
        if (!list.contains(random)) {
            list.add(random);
        }
    }
}
