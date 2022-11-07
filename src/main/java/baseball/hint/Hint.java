package baseball.hint;

import java.util.List;

public class Hint {
    private int ball = 0;
    private int strike = 0;

    public Hint(List<Integer> computerNum, List<Integer> userNum){
        ball = 0;
        strike = 0;
        checkStrikeBall(computerNum, userNum);
    }

}

