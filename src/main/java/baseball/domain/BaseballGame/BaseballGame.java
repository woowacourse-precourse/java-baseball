package baseball.domain.BaseballGame;

import baseball.StringEnum.Game;
import baseball.domain.Computer.Computer;
import baseball.domain.Hint.Hint;
import baseball.domain.Hint.HintString;
import baseball.domain.Player.Player;
import baseball.domain.Validation.Ball;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private boolean isPlaying;

    public BaseballGame() {
        computer = new Computer();
        player = new Player();
        isPlaying = true;
    }

    public void start() {
        computer.generateRandomNumbers();
        System.out.println(Game.START.getContent());
        play();
        //사용자 restart 입력 (validateRestart) -> 게임 재시작 여부 판별
    }

    private void play() {
        while (isPlaying) {
            getPlayerNumber();
            String hint = getHint();
            printHint(hint);
            checkPlayerWin(hint);
        }
    }

    private void getPlayerNumber() {
        System.out.print(Game.INPUT.getContent());
        player.readBallNumberInput(Console.readLine());
    }

    private String getHint() {
        Hint hint = new Hint();
        return hint.printHint(player.getBallNumbers(), computer.getBallNumbers());
    }

    private void printHint(String hintString) {
        System.out.println(hintString);
    }

    private void checkPlayerWin(String hint) {
        if (hint.equals(HintString.STRIKE.print(3))) {
            System.out.printf((Game.END.getContent()) + "\n", Ball.COUNT.getValue());
            isPlaying = false;
        }
    }

}
