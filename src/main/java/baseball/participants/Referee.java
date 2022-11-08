package baseball.participants;

import java.util.ArrayList;
import java.util.List;

/**
 * 투수(게이머)와 타자(컴퓨터)의 게임 결과를 판단합니다.
 */
public class Referee {
    final private int WIN_CONDITION = 3;
    private boolean winsGame;

    public Referee() {
    }

    public boolean doesPitcherWin() {
        return winsGame;
    }

    public void judge(StrikeZone pitchZone, StrikeZone swingZone) {
        String pitches = pitchZone.toString();
        String swings = swingZone.toString();

        int strike = 0;
        int ball = 0;
        List<Integer> usedSwingIndices = new ArrayList<>();

        for (int pitchIndex = 0; pitchIndex < pitches.length(); pitchIndex++) {
            if (isStrike(pitches.charAt(pitchIndex), swings.charAt(pitchIndex))) {  // Strike 판단
                usedSwingIndices.add(pitchIndex);
                strike += 1;
                continue;
            }

            String pitch = Character.toString(pitches.charAt(pitchIndex));
            int swingIndex = judgeBall(pitch, swings, usedSwingIndices);    // Ball 판단
            if (swingIndex != -1) {
                usedSwingIndices.add(swingIndex);
                ball += 1;
            }
        }

        printJudgement(strike, ball);
        winsGame = (strike == WIN_CONDITION);
    }

    private Integer judgeBall(String pitch, String swings, List<Integer> usedSwingIndices) {
        int swingIndex = 0;
        while (true) {
            swingIndex = swings.indexOf(pitch, swingIndex);
            if (swingIndex == -1) { // 같은 숫자가 없다면
                break;
            }
            if (usedSwingIndices.contains(swingIndex)) {
                swingIndex += 1;
                continue;
            }
            return swingIndex;
        }
        return -1;
    }

    private boolean isStrike(char pitch, char swing) {
        return pitch == swing;
    }

    private void printJudgement(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        System.out.print(strike + "스트라이크"); // ball == 0
    }
}