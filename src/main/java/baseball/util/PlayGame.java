package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {

    public boolean playWithComputer(List<Integer> player, List<Integer> com) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int index = 0; index < 3; index++) {
            if (player.get(index).equals(com.get(index))) {
                strikeCnt++;
                continue;
            }
            if (com.contains(player.get(index))) {
                ballCnt++;
            }
        }
        boolean isExactNumber = printScore(strikeCnt, ballCnt);
        return isExactNumber;
    }

    private boolean printScore(int strikeCnt, int ballCnt) {
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }else {
            System.out.println(ballCnt+"볼 "+strikeCnt+"스트라이크");
        }
        return false;
    }
}
