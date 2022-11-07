package baseball.game;

import baseball.computer.Computer;
import baseball.hint.Hint;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;


public class Game {
    private boolean exit = false;
    private boolean play_exit;
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";

    public void start() {
        System.out.println(START_STRING);
        while (!exit) {
            play();
            exit = restartOrEnd();
        }
    }

    public void play() {
        Player player = new Player();
        Computer computer = new Computer();
        play_exit = false;

        while (!play_exit) {
            player.inputNumber();
            Hint hint = new Hint(computer.getComputerNum(), player.getInputNum());
            hint.printResult();
            play_exit = hint.checkWin();
        }
    }
}