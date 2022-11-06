package baseball.view;

import baseball.model.Ball;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    public static Balls input() {
        System.out.print("숫자를 입력해주세요 : ");
        return input(Console.readLine());
    }

    public static Balls input(String input) {
        Pattern pattern = Pattern.compile("^[1-9]{3}$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input = getRematchInput();

        if (input == 1) return true;
        if (input == 2) return false;
        throw new IllegalArgumentException();
    }

    private static int getRematchInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
