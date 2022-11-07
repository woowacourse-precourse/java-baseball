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

    public void checkStrikeBall(List<Integer> computerNum, List<Integer> playerNum){
        for(int i = 0; i < playerNum.size(); i++){
            int playerNumDigit = playerNum.get(i);
            if(computerNum.indexOf(playerNumDigit) == i){
                strike += 1;
            } else if (computerNum.indexOf(playerNumDigit) != i & computerNum.contains(playerNumDigit)) {
                ball += 1;
            }
        }
    }
}

