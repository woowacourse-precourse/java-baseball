package baseball.controller;

import baseball.ball.Ball;
import baseball.model.Model;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Model model = new Model();
    View view = new View();
    Ball baseball = new Ball();
    String input;
    int number;
    int strike;
    int ball;
    public void start() {
        view.startMention();
        while (true) {
            view.printInput();
            input = Console.readLine();
            if (!model.findException(input)) throw new IllegalArgumentException();
            if (checkBallAndStrike()) continue;
            input = Console.readLine();
            if (model.InputException(input)) throw new IllegalArgumentException();
            if (regame()) break;
        }
    }
    private boolean checkBallAndStrike() {
        number = Integer.parseInt(input);
        strike = model.findStrike(baseball.getScore(), number);
        ball = model.findBall(baseball.getScore(), number);

        if (ball == 0 && strike == 0) {
            view.incorrect();
            return true;
        } else if (ball != 0 && strike != 0) {
            view.strikeAndBall(strike, ball);
            return true;
        } else if (ball != 0) {
            view.ball(ball);
            return true;
        } else if (strike <3) {
            view.strike(strike);
            return true;
        } else if (strike == 3) {
            view.threeStrike();
        }
        return false;
    }
    private boolean regame() {
        if ("1".equals(input)) {
            baseball = new Ball();
        } else if ("2".equals(input)) {
            return true;
        }
        return false;
    }
}
