package baseball;

import java.util.List;

public class Referee {
    private int gameCount = 0;

    public String scoring(List<Integer> answer, List<Integer> userAnswer) {
        int ballCount = 0;
        int strikeCount = 0;

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

        StringBuilder decision = new StringBuilder();

        if (ballCount != 0) {
            decision.append(ballCount + "볼 ");
        }

        if (strikeCount != 0) {
            decision.append(strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            decision.append("낫싱");
        }

        gameCount++;

        if (strikeCount == 3) {
            decision.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameCount = 3;
        }

        return decision.toString().trim();
    }
}
