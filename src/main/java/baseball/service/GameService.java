package baseball.service;

import baseball.utils.PrintMessage;
import baseball.utils.RandomNumber;
import domain.Game;
import domain.User;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {

    PrintMessage print = new PrintMessage();
    RandomNumber computer = new RandomNumber();
    Game game = new Game();
    User user = new User();
    InGame inGame = new InGame();
    String input;

    List<Integer> computerNumber;

    public void playGame() {
        computerNumber = computer.newRandomNumber();
        int strike = 0;
        while (strike != 3) {
            print.inputRequest();
            play();
            print.status(game.getBall(), game.getStrike());
            strike = game.getStrike();
        }
    }

    private void play() {
        game.initStrike();
        game.initBall();
        int[] userNumbers = getUserNumbers();
        user.setUserNumber(userNumbers);
    }
    private int[] getUserNumbers() throws IllegalArgumentException{
        input = readLine();
        return inGame.userInputToInt(input);
    }

}
