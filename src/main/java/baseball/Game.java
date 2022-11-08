package baseball;

import baseball.constant.Message;
import java.util.List;

public class Game {

    private static final Computer computer = new Computer();
    private static final Player player = new Player();

    public static void play() {
        computer.createAnswerNumber();

        List<Integer> guessNumber;
        do {
            System.out.println(Message.ENTER_NUMBER);
            guessNumber = player.createGuessNumber();
        } while (!computer.checkResult(guessNumber));
    }
}
