package baseball.game;

import baseball.computer.Computer;
import baseball.hint.Hint;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;


public class Game {
    private boolean exit = false;
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";

    public void start() {
        System.out.println(START_STRING);
        while (!exit) {
            play();
            exit = restartOrEnd();
        }
    }
}