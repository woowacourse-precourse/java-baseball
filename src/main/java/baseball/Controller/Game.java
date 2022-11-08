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
        StrikeOutCheck(userInput);
    }

    public void getUserInput(String userInput) {
        if (user.inputCheck(userInput)) {
            print.inputMessage(userInput);
        }
    }

    public String ballHint(String userInput) {
        return computer.ballHintCheck(userInput);
    }

    public void StrikeOutCheck(String userInput) {
        String ball = ballHint(userInput);
        print.hintMessage(ball);
        if (!Objects.equals(ball, 3 + Constant.HINT_STRIKE)) {
            gameStart();
            return;
        }
        print.hintMessage(Constant.STRIKE_OUT);
        print.hintMessage(Constant.RESTART);
        restartCheck();
    }

    public void restartCheck() {
        String input = Console.readLine();
        user.restartInputCheck(input);
        if (!Objects.equals(input, Constant.END)) {
            computer.setComputerInput();
            gameStart();
            return;
        }
        System.out.println("게임 끝");
    }

}
