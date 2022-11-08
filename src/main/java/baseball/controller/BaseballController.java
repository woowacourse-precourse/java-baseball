package baseball.controller;

import baseball.model.Computer;
import baseball.model.Umpire;
import baseball.model.User;
import baseball.view.BaseballConsole;

public class BaseballController {

    public void start() {
        do {
            play();
        } while (checkContinueBaseball());
    }

    private void play() {
        Computer computer = new Computer();
        User user;
        Umpire umpire;

        do {
            user = new User();
            umpire = new Umpire();
            BaseballConsole.printUserInputNumber();
            String userInputNumber = BaseballConsole.readUserInputNumber();
            user.addUserNumbers(userInputNumber);

            umpire.decideCount(computer.getNumbers(), user.getNumbers());

            BaseballConsole.printStrikeBallCount(umpire.getStrikeCount(), umpire.getBallCount());
        } while (!umpire.is3Strike());

        BaseballConsole.printEndBaseBall();
    }

    private boolean checkContinueBaseball() {
        BaseballConsole.printCheckContinueBaseball();
        String input = BaseballConsole.readCheckContinueInput();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1과 2의 숫자만 입력할 수 있습니다.");
    }

}
