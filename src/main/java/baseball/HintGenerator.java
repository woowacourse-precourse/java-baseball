package baseball;

import baseball.Messages.ProgramMessages;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class HintGenerator {
    private int strikeCount;
    private int ballCount;
    private List<Integer> pitcherNumbers;
    private List<Integer> catcherNumbers;
    private String hint;

    HintGenerator(Pitcher pitcher, Catcher catcher) {
        pitcherNumbers = pitcher.getPitcherNumbers();
        catcherNumbers = catcher.getCatcherNumbers();
        strikeCount = 0;
        ballCount = 0;
        hint = "";
    }

    public String generateHint() {
        for (int num : pitcherNumbers) {
            if (catcherNumbers.contains(num)) {
                strikeOrBall(num);
            }
        }
        if (strikeCount == 0 && ballCount == 0) {
            hint = ProgramMessages.NOTHING;
        } else if (strikeCount > 0 && ballCount == 0) {
            hint = strikeCount + ProgramMessages.STRIKE;
        } else if (strikeCount == 0 && ballCount > 0) {
            hint = ballCount + ProgramMessages.BALL;
        } else {
            hint = ballCount + ProgramMessages.BALL + " " + strikeCount + ProgramMessages.STRIKE;
        }
        return hint;
    }

    /**
     * num의 인덱스까지 겹치는지 확인
     * 겹친다면 strike, 안 겹친다면 ball
     *
     * @param num
     */
    public void strikeOrBall(int num) {
        int index = pitcherNumbers.indexOf(num);
        if (catcherNumbers.indexOf(num) == index) {
            strikeCount++;
        } else {
            ballCount++;
        }
    }
}
