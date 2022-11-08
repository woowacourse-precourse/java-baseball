package baseball;

import baseball.constant.Message;
import java.util.List;

public class Game {

    private static final Computer computer = new Computer();
    private static final Player player = new Player();

    public static void start() {
        do {
            System.out.println(Message.START_BASEBALL_GAME);
            play();
            System.out.println(Message.END_BASEBALL_GAME);
        } while (player.restart());
    }

    private static void play() {
        computer.createAnswerNumber();

        List<Integer> guessNumber;
        do {
            System.out.print(Message.ENTER_NUMBER);
            guessNumber = player.createGuessNumber();
        } while (!computer.checkResult(guessNumber));
    }
}
