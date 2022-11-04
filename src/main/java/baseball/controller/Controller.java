package baseball.controller;

import baseball.repository.Repository;
import baseball.service.Service;
import baseball.view.View;
import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Service service = new Service();
    View view = new View();
    Repository repository = new Repository(service.generateScore());
    Exception ex = new Exception();
    String input;
    int number;
    int strike;
    int ball;

    public void start() {
        view.startMention();
        while (true) {
            view.printInput();
            input = Console.readLine();
            if (!ex.scoreException(input)) throw new IllegalArgumentException();
            if (!ex.checkInputSame(input)) throw new IllegalArgumentException();
            if (checkBallAndStrike()) continue;
            input = Console.readLine();
            if (ex.regameException(input)) throw new IllegalArgumentException();
            if (regame()) break;
        }
    }

    private boolean checkBallAndStrike() {
        number = Integer.parseInt(input);
        strike = service.findStrike(repository.getScore(), number);
        ball = service.findBall(repository.getScore(), number);

        if (ball == 0 && strike == 0) {
            view.incorrect();
            return true;
        } else if (ball != 0 && strike != 0) {
            view.strikeAndBall(strike, ball);
            return true;
        } else if (ball != 0) {
            view.ball(ball);
            return true;
        } else if (strike < 3) {
            view.strike(strike);
            return true;
        } else if (strike == 3) {
            view.threeStrike();
        }
        return false;
    }

    private boolean regame() {
        if ("1".equals(input)) {
            repository = new Repository(service.generateScore());
        } else if ("2".equals(input)) {
            return true;
        }
        return false;
    }
}
