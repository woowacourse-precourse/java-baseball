package baseball.system;

import static baseball.util.Constant.*;

import baseball.player.Computer;
import baseball.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Computer computer;
    private Player player;
    private int strikeCnt;
    private int ballCnt;

    public Game() {
        computer = new Computer();
        player = new Player();
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

}
