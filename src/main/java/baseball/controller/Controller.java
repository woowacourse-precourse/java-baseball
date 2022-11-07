package baseball.controller;

import baseball.computer.Computer;
import baseball.service.Service;
import baseball.view.View;
import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Controller {
    Service service = new Service();
    Computer computer = new Computer();
    View view = new View();
    Exception ex = new Exception();
    String input;
    int number;
    int strike;
    int ball;
    int score;

    public void start() {
        view.startMention();
        score = computer.generateScore();
        while (true) {
            view.printInput();
            input = Console.readLine();
            if (checkBallAndStrike()) continue;
            input = Console.readLine();
            if (regame()) break;
        }
    }

    private boolean checkBallAndStrike() {
        if (!ex.scoreException(input)) throw new IllegalArgumentException();
        if (!ex.checkInputSame(input)) throw new IllegalArgumentException();

        number = Integer.parseInt(input);
        strike = service.findStrike(score, number);
        ball = service.findBall(score, number);

        if (Objects.equals(ball, 0) && Objects.equals(strike, 0)) {
            view.incorrect();
        } else if (!Objects.equals(ball, 0) && !Objects.equals(strike, 0)) {
            view.strikeAndBall(strike, ball);
        } else if (!Objects.equals(ball, 0)) {
            view.ball(ball);
        } else if (!Objects.equals(strike, 3)) {
            view.strike(strike);
        } else if (Objects.equals(strike, 3)) {
            view.threeStrike();
            return false;
        }
        return true;
    }

    private boolean regame() {
        if (ex.regameException(input)) throw new IllegalArgumentException();

        if (Objects.equals("1", input)) {
            score = computer.generateScore();
        } else if (Objects.equals("2", input)) {
            return true;
        }
        return false;
    }
}
