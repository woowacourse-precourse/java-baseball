package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InGame extends UserGuessInput{
    private Map<String, Integer> count = new HashMap<>();
    private List<Integer> input;
    private List<Integer> answer;
    private boolean isAllStrike;

    protected InGame(List<Integer> answer, boolean isAllStrike){
        this.answer = answer;
        this.isAllStrike = isAllStrike;
        this.InGameProcess();
    }

    protected void InGameProcess(){
        while(!isAllStrike){
            this.input = processUserInput();
            this.count = new Counter(input, answer).getCount();
            boolean isEnd = new Result(count).computeResult();
            if(isEnd) break;
        }
    }
}