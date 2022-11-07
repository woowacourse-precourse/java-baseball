package baseball.game;

import baseball.computer.Computer;
import baseball.hint.Hint;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;


public class Game {
    private boolean exit = false;
    private boolean play_exit;
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String EXIT_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

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

    public boolean restartOrEnd() {
        System.out.println(EXIT_STRING);
        String input = Console.readLine();

        if (input.equals("1")){
            return false;
        } else if (input.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("1,2 중 하나만 입력하세요.");
        }
    }
}