package baseball;

import java.util.List;

public class Referee {

    private boolean isPlaying = true;
    private int ballCount = 0;
    private int strikeCount = 0;

    public String scoring(List<Integer> answer, List<Integer> userAnswer) {
        ballCount = 0;
        strikeCount = 0;

        countBallsAndStrikes(answer, userAnswer);

        if (strikeCount == 3) {
            isPlaying = false;
        }

        return createDecisionMessage(ballCount, strikeCount);
    }

    public boolean isEnd() {
        return !isPlaying;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void playGame() {
        isPlaying = true;
    }

    private void countBallsAndStrikes(List<Integer> answer, List<Integer> userAnswer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer.get(i) == userAnswer.get(j)) {
                    if (i == j) {
                        strikeCount++;
                    }
                    else if (i != j){
                        ballCount++;
                    }
                }
            }
        }
    }

    private String createDecisionMessage(int ballCount, int strikeCount) {
        StringBuilder decisionMessage = new StringBuilder();

        if (ballCount != 0) {
            decisionMessage.append(ballCount + "볼 ");
        }

        if (strikeCount != 0) {
            decisionMessage.append(strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            decisionMessage.append("낫싱");
        }

        if (strikeCount == 3) {
            decisionMessage.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        return decisionMessage.toString().trim();
    }
}
