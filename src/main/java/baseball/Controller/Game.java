package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.User;
import baseball.View.Print;
import camp.nextstep.edu.missionutils.Console;

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
    }

    public void getUserInput(String userInput) {
        if (user.inputCheck(userInput)) {
            print.inputMessage(userInput);
        }
    }

}
