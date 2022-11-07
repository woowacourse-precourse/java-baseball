package baseball.controller;

import baseball.repository.Repository;
import baseball.service.Service;
import baseball.view.View;
import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Controller {
    Service service = new Service();
    View view = new View();
    Exception ex = new Exception();
    Repository repository = new Repository();
    String input;
    int number;
    int strike;
    int ball;

    public void start() {
        view.startMention();
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
        strike = service.findStrike(repository.getScore(), number);
        ball = service.findBall(repository.getScore(), number);

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
            repository = new Repository();
        } else if (Objects.equals("2", input)) {
            return true;
        }
        return false;
    }
}
