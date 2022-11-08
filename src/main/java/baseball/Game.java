package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.util.Platform;

import java.util.List;

public class Game {
    private static int MAX_BALL_COUNT;
    private final Computer computer;

    public Game(Computer computer, User user, int count) {
        this.computer = computer;
        MAX_BALL_COUNT = count;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computerNums = computer.createNums(MAX_BALL_COUNT);
        }
    }
}

