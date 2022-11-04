package baseball.view;

import baseball.model.Ball;
import baseball.model.Balls;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static Balls input(String input) {
        Pattern pattern = Pattern.compile("^[1-9]{3}$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return asBalls(Integer.parseInt(input));
    }

    private static Balls asBalls(int num) {
        List<Ball> ballList = new ArrayList<>();

        for (int position = 2; position >= 0; position--) {
            Ball ball = new Ball(num % 10, position);
            ballList.add(ball);
            num /= 10;
        }

        return new Balls(ballList);
    }
}
