package baseball.system;

import static baseball.util.Constant.*;

import baseball.player.Computer;
import baseball.player.Player;
import baseball.validation.Validation;
import java.util.List;

public class Game {

    private Computer computer;
    private Player player;
    private Validation validation;
    private int strikeCnt;
    private int ballCnt;

    public Game() {
        computer = new Computer();
        player = new Player();
        validation = new Validation();
        strikeCnt = 0;
        ballCnt = 0;
    }

    /**
     * 컴퓨터가 만든 램던한 수와 플레이어가 제시한 수를 비교해 스크라이크인지 볼인지 판별하는 기능
     * @param problem 컴퓨터가 만든 수
     * @param answer 플레이어가 제시한 숫
     */
    public void isStrikeOrBall(List<Integer> problem, String answer) {
        for (int i = 0; i < 3; i++) {
            if (problem.get(i) == answer.charAt(i) - '0') {
                strikeCnt++;
            } else if (problem.contains(answer.charAt(i) - '0')) {
                ballCnt++;
            }
        }
    }

    /**
     * 스트라이크의 수를 반환하는 기능
     */
    public int getStrikeCnt() {
        return strikeCnt;
    }

    /**
     * 볼의 수를 반환하는 기능
     */
    public int getBallCnt() {
        return ballCnt;
    }

    /**
     * hint를 제공하는 기능
     */
    public void giveHint(List<Integer> problem, String answer) {
        isStrikeOrBall(problem, answer);
        String hint = "";
        if (strikeCnt == 0 && ballCnt == 0) {
            hint = NOTHING;
        } else if (strikeCnt == 0) {
            hint = ballCnt + BALL;
        } else if (ballCnt == 0) {
            hint = strikeCnt + STRIKE;
        } else if (!(strikeCnt == 0 && ballCnt == 0)) {
            hint = ballCnt + BALL + " " + strikeCnt + STRIKE;
        }
        System.out.println(hint);
    }

    /**
     * 플레이어가 정답을 맞추었는지 판별하는 기능
     * @return 3스트라이크이면 true 반환 그렇지 않으면 false 반환
     */
    public boolean correct() {
        if (strikeCnt == 3) {
            System.out.println(GAME_END_MSG);
            return true;
        }
        return false;
    }

    /**
     * 게임을 재시작하는지 판별하는 기능
     * @return 게임을 재시작하면 true 그러지 않으면 false 잘못된 값이 입력되면 오류발생
     */
    public boolean checkReplay() {
        System.out.println(RESTART_OR_EXIT);
        String reply = player.restartOrExit();
        if (reply.equals("1")) {
            return true;
        } else if (reply.equals("2")) {
            return false;
        }
        validation.checkRestartOrExitValidation(reply);
        return false;
    }
}
