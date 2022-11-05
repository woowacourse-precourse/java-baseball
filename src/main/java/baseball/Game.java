package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import baseball.logic.GameLogic;
import baseball.screen.InputResolver;
import baseball.screen.OutputResolver;

public class Game {
    Computer computer = new Computer();
    User user = new User();
    GameLogic gameLogic = new GameLogic();
    Result result = new Result(-1, -1);
    InputResolver inputResolver = new InputResolver();
    OutputResolver outputResolver = new OutputResolver();

    public void start() {
        gameLogic.setUp(computer.getNumbers());

        while (result.getStrike() != 3) {
            inputResolver.inputUserNumber();
            gameLogic.process(user.getNumbers(), result);
//            outputResolver.print(result);
        }
    }


}
