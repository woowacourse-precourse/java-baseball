package baseball;

import baseball.game.Computer;
import baseball.game.Player;
import baseball.message.SystemMessage;
import java.util.List;

public class Application {

    public static final int CONTINUE_GAME = 1;
    public static final int STOP_GAME = 2;

    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        String continueOrStop = "";
        do {
            System.out.println(computer.startGame().toString()); // TODO: computer.startGame(); 로 변경
            doGame(computer, player);
            continueOrStop = player.inputContinueOrStop();
        } while (Integer.parseInt(continueOrStop) == CONTINUE_GAME);
    }

    private static void doGame(Computer computer, Player player) {
        String result;
        do {
            List<Integer> playerNumber = player.inputPlayerNumber();
            result = computer.playGame(playerNumber);
            System.out.println(result);
        } while (!result.equals(SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER));
    }
}
