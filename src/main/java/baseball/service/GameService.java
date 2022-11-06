package baseball.service;

import baseball.utils.PrintMessage;
import baseball.utils.RandomNumber;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {

    PrintMessage print = new PrintMessage();
    RandomNumber computer = new RandomNumber();
    InGame inGame = new InGame();
    String input;
    public void gameStart() {
        input = readLine();
        print.inputRequest();
        inGame.validate(input);
    }
}
