package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.User;
import baseball.Util.Constant;
import baseball.View.Print;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Game {
    private final Print print = new Print();
    private final User user = new User();
    private final Computer computer = new Computer();

    public Game() {
        print.gameStart();
        computer.setComputerInput();
    }

    public void gameStart() {
        String userInput = Console.readLine();
        getUserInput(userInput);
        ballHint(userInput);
    }

    public void getUserInput(String userInput) {
        if (user.inputCheck(userInput)) {
            print.inputMessage(userInput);
        }
    }
    public void ballHint(String userInput){
        String ball = computer.ballHintCheck(userInput);
        print.hintMessage(ball);
    }

}
