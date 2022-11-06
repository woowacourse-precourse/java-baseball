package baseball.domain.BaseballGame;

import baseball.StringEnum.Game;
import baseball.domain.Computer.Computer;
import baseball.domain.Hint.Hint;
import baseball.domain.Hint.HintString;
import baseball.domain.Player.Player;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
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
        String hintStatement =  hint.printHint();
        checkPlayerWin(hintStatement);
    }

    private void checkPlayerWin(String hint) {
        if (hint.equals(HintString.STRIKE.print(3))) {
            System.out.println(Game.END);
            isPlaying = false;
        }
    }

    private void checkGameRestart() {
        System.out.println(Game.RESTART);
        isStartRequested = player.readRestartInput(Console.readLine());
    }

}
