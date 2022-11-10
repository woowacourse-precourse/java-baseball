package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.util.Platform;

import java.util.List;

public class Game {
    private static int MAX_BALL_COUNT;
    private static final int RESTART = 1;
    private static final int FINISH = 2;
    private final Computer computer;
    private final User user;

    public Game(Computer computer, User user, int count) {
        this.computer = computer;
        this.user = user;
        MAX_BALL_COUNT = count;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computerNums = computer.createNums(MAX_BALL_COUNT);
            playStage(computerNums, MAX_BALL_COUNT);
            if(isFinished()) {
                break;
            }
        }
    }

    public void playStage(List<Integer> computerNums, int count) {
        while (true) {
            List<Integer> userNums = user.createNums(user.getInputs(), MAX_BALL_COUNT);
            Hint hint = new Hint(userNums, computerNums, count);
            if (isStageEnded(hint.getStrike())) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }

    private boolean isStageEnded(int strike) {
        return strike == MAX_BALL_COUNT;
    }

    private boolean isFinished() {
        int flag = Integer.parseInt(Console.readLine());
        System.out.println(flag);
        if (flag == RESTART) {
            return false;
        }
        if (flag == FINISH) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}

