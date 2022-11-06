package baseball.controller;

import baseball.model.Computer;
import baseball.model.Umpire;
import baseball.model.User;
import baseball.view.BaseballConsole;

public class BaseballController {

    private final Computer computer;
    private final User user;
    private final Umpire umpire;

    public BaseballController() {
        this.computer = new Computer();
        this.user = new User();
        this.umpire = new Umpire();
    }

    public void play() {
        while(!umpire.is3Strike()) {
            BaseballConsole.printUserInputNumber();
            String userInputNumber = BaseballConsole.readUserInputNumber();
            user.addUserNumbers(userInputNumber);

            umpire.decideCount(computer.getNumbers(), user.getNumbers());

            BaseballConsole.printStrikeBallCount(umpire.getStrikeCount(), umpire.getBallCount());
        }
        BaseballConsole.printEndBaseBall();
    }


}
