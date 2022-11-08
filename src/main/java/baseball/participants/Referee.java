package baseball.participants;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    final private int WIN_CONDITION = 3;
    private boolean winsGame;

    public Referee() {
    }

    public boolean doesPitcherWin() {
        return winsGame;
    }

    public void judge(StrikeZone pitchZone, StrikeZone swingZone) {
        int strike;
        int ball;

        String pitches = pitchZone.toString();
        String swings = swingZone.toString();

        strike = countStrike(pitches, swings);
        ball = countBall(pitches, swings);

        printJudgement(strike, ball);
        winsGame = (strike == WIN_CONDITION);
    }

    private Integer countStrike(String pitches, String swings) {
        int strike = 0;
        for (int idx = 0; idx < pitches.length(); idx++) {
            if (isStrike(pitches.charAt(idx), swings.charAt(idx))) {
                strike += 1;
            }
        }
        return strike;
    }

    private Integer countBall(String pitches, String swings) {
        List<Integer> swingIndicesCountedAsStrike = new ArrayList<>();
        for (int idx = 0; idx < pitches.length(); idx++) {
            if (isStrike(pitches.charAt(idx), swings.charAt(idx))) {
                swingIndicesCountedAsStrike.add(idx);
            }
        }

        int ball = 0;
        List<Integer> swingIndicesCountedAsBall = new ArrayList<>();
        for (int pitchIndex = 0; pitchIndex < pitches.length(); pitchIndex++) {
            String pitch = Character.toString(pitches.charAt(pitchIndex));
            if (swingIndicesCountedAsStrike.contains(pitchIndex)) {
                continue;
            }
            int swingIndex = 0;
            while (true) {
                swingIndex = swings.indexOf(pitch, swingIndex);
                if (swingIndex == -1) { // 같은 숫자가 없다면
                    break;
                }
                if (swingIndicesCountedAsStrike.contains(swingIndex)) {
                    swingIndex += 1;
                    continue;
                }
                if (swingIndicesCountedAsBall.contains(swingIndex)) {
                    swingIndex += 1;
                    continue;
                }
                if (isStrike(pitchIndex, swingIndex)) {
                    swingIndicesCountedAsBall.add(swingIndex);
                    break;
                }
                ball += 1;
                swingIndicesCountedAsBall.add(swingIndex);
                break;
            }
        }
        return ball;
    }

    private boolean isStrike(char pitch, char swing) {
        return pitch == swing;
    }

    private boolean isStrike(int pitchIndex, int swingIndex) {
        return pitchIndex == swingIndex;
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