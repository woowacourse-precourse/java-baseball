package baseball;

import baseball.common.GameMessage;
import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void startGame(Exception exception) {
        System.out.println(GameMessage.START_GAME.getValue());
        Computer computer = new Computer();

        boolean reStartGame = true;

        while (reStartGame) {
            System.out.println(GameMessage.QUESTION__NUMBER.getValue());
            String input = Console.readLine();

            exception.createNumberInputException(input);

            String status = computer.getStatus(input);
            System.out.println(status);
            reStartGame = questNext(input, computer);
        }
    }

    public boolean questNext(String input, Computer computer) {
        if (computer.countStrike(input) == 3) {
            System.out.println(GameMessage.GAME_OVER.getValue());
            return false;
        }
        return true;
    }

}
