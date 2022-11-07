package baseball.game;
import baseball.Message;
import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;
import org.mockito.internal.stubbing.answers.DoesNothing;

import javax.swing.*;

import static baseball.Message.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallCounter {

    final int MATCH_NUM = 3;

    List<String> playerNumber;
    List<String> targetNumber;
    List<Boolean> numberState = new ArrayList<>(Arrays.asList(false,false,false));


    public boolean countScore(PlayerNumber playerNumber, TargetNumber targetNumber) {
        int strikeCnt;
        int ballCnt;

        this.playerNumber = playerNumber.getNumber();
        this.targetNumber = targetNumber.getNumber();
        initNumberState();
        strikeCnt = countStrike();
        ballCnt = countBall();

        return isClear(strikeCnt, ballCnt);
    }

    public int countStrike() {
        int strikeCount = 0;

        for (int idx = 0; idx < targetNumber.size(); idx++) {
            if (playerNumber
                    .get(idx).equals(targetNumber.get(idx))) {
                numberState.set(idx, true);
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall() {
        int ballCount = 0;

        for (int idx = 0; idx< targetNumber.size(); idx++){
            if (targetNumber.contains(playerNumber.get(idx)) && !numberState.get(idx)) {
                numberState.set(idx, true);
                ballCount++;
            }
        }
        return ballCount;
    }

    public void initNumberState() {
        for (int i = 0; i < targetNumber.size(); i++) {
            numberState.set(i, false);
        }
    }

    public void printBallCount(int strikeCnt, int ballCnt) {
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ballCnt == 0) {
            System.out.println(strikeCnt + STRIKE);
            return;
        }
        if (strikeCnt == 0) {
            System.out.println(ballCnt + BALL);
            return;
        }
        System.out.println(ballCnt + BALL + " " + strikeCnt + STRIKE);
    }

    public boolean isClear(int strikeCnt, int ballCnt) {
        if (strikeCnt == MATCH_NUM){
            printBallCount(strikeCnt, ballCnt);
            System.out.println(END_MESSAGE);
            return false;
        }
        printBallCount(strikeCnt, ballCnt);
        return true;
    }
}
