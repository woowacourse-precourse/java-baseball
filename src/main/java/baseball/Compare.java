package baseball;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    public int getMatchResult(ArrayList<Integer> answerNumList, ArrayList<Integer> playerNumList) {
        int result = 0;
        for(int i = 0; i < playerNumList.size(); i++) {
            if(answerNumList.contains(playerNumList.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int strikeCount(ArrayList<Integer> answerNumList, ArrayList<Integer> playerNumList) {
        int strike = 0;
        for(int i = 0; i < answerNumList.size(); i++) {
            if(answerNumList.get(i) == playerNumList.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }
}
