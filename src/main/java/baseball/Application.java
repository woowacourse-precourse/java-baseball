package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int START = 1;
    private static final int STOP = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int runCode = 1;
        while (runCode == START) {
            Computer computer = new Computer();
            Player player = new Player(Console.readLine());
        }
    }
}
