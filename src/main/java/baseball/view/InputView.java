package baseball.view;

import baseball.model.Ball;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final int REMATCH_NUMBER = 1;
    private static final int NO_REMATCH_NUMBER = 2;
    private static final String INPUT_SIGN = "숫자를 입력해주세요 : ";
    private static final String REMATCH_SIGN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ERR_REMATCH_INPUT = "게임 시작하려면 1만 입력하고 종료하려면 2만 입력해야 합니다.";
    private static final String ERR_GAME_INPUT = "입력 숫자는 1 ~ 9의 자릿수를 가진 3 자리 숫자입니다.";
    private static final String USER_INPUT_PATTERN = "^[1-9]{3}$";

    public static Balls input() {
        System.out.print(INPUT_SIGN);
        return input(Console.readLine());
    }

    public static Balls input(String input) {
        Pattern pattern = Pattern.compile(USER_INPUT_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERR_GAME_INPUT);
        }
        return asBalls(input);
    }

    private static Balls asBalls(String input) {
        List<Ball> ballList = new ArrayList<>();

        for (int position = 0; position < Balls.NUMBER_OF_BALLS; position++) {
            int digit = input.charAt(position) - '0';
            Ball ball = new Ball(digit, position);
            ballList.add(ball);
        }

        return new Balls(ballList);
    }

    public static boolean isRematch() {
        System.out.println(REMATCH_SIGN);

        int input = getRematchInput();

        if (input == REMATCH_NUMBER) return true;
        if (input == NO_REMATCH_NUMBER) return false;
        throw new IllegalArgumentException(ERR_REMATCH_INPUT);
    }

    private static int getRematchInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ERR_REMATCH_INPUT);
        }
    }
}
