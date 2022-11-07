package baseball.domain.game;

import baseball.stringenum.Game;
import baseball.domain.computer.Computer;
import baseball.domain.hint.Hint;
import baseball.domain.hint.HintString;
import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String gameEndCondition = HintString.STRIKE.print(Ball.COUNT.getValue());
    private final Computer computer;
    private final Player player;
    private boolean isPlaying;
    private boolean isStartRequested;

    public BaseballGame() {
        computer = new Computer();
        player = new Player();
        isPlaying = true;
        isStartRequested = true;
    }

    public void start() {
        System.out.println(Game.START);

        while (isStartRequested) {
            isPlaying = true;
            computer.generateRandomNumbers();
            play();
            checkGameRestart();
        }
    }

    private void play() {
        while (isPlaying) {
            getPlayerNumber();
            printHint();
        }
    }

    private void getPlayerNumber() {
        System.out.print(Game.INPUT);
        player.readBallNumberInput(Console.readLine());
    }

    private void printHint() {
        Hint hint = new Hint(player.getBallNumbers(), computer.getBallNumbers());
        String hintStatement = hint.printHint();
        checkPlayerWin(hintStatement);
    }

    private void checkPlayerWin(String hint) {
        if (hint.equals(gameEndCondition)) {
            System.out.println(Game.END);
            isPlaying = false;
        }
    }

    private void checkGameRestart() {
        System.out.println(Game.RESTART);
        isStartRequested = player.readRestartInput(Console.readLine());
    }

}
