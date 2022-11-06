package baseball.participants;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Referee {
    public boolean isGameInProgress;
    public boolean toTerminateGame;
    private final String PLAY_AGAIN = "1";
    private final String TERMINATE = "2";

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        isGameInProgress = true;
        toTerminateGame = false;
    }

    public void startPitch() {
        System.out.println("3자리 숫자를 입력해주세요 : ");
    }

    public void judge(StrikeZone pitchZone, StrikeZone swingZone) {
        int strike;
        int ball;

        String pitches = pitchZone.toString();
        String swings = swingZone.toString();

        strike = countStrike(pitches, swings);
        ball = countBall(pitches, swings);

        printJudgement(strike, ball);
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        isGameInProgress = false;
    }

    public void playAgainOrNot() {
        String againOrTerminate = readLine();
        while (!validatePlayAgain(againOrTerminate)) {
            System.out.println(PLAY_AGAIN + " 혹은 " + TERMINATE + "만 입력해주세요.");

            againOrTerminate = readLine();
        }
        if (againOrTerminate.equals(PLAY_AGAIN)) {
            System.out.println("게임을 다시 시작합니다.");
        }
        if (againOrTerminate.equals(TERMINATE)) {
            System.out.println("게임을 완전히 종료합니다.");
        }
        toTerminateGame = againOrTerminate.equals(TERMINATE);
    }

    private boolean validatePlayAgain(String againOrTerminate) {
        return againOrTerminate.equals(PLAY_AGAIN) || againOrTerminate.equals(TERMINATE);
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
                    swingIndex +=1;
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
                swingIndex += 1;
                break;
            }
        }
        return ball;
    }

    private boolean isStrike(char pitch, char swing) {
        return pitch == swing;
    }

    private boolean isStrike(int pitch, int swing) {
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
        if (ball == 0 && strike < 3) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            this.isGameInProgress = false;
        }
    }
}