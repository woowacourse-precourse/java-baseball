package baseball.service;


import baseball.model.Hint;
import baseball.model.Input;
import java.util.List;

public class Service {
    private final List<Integer> answer;

    public Service(){
        answer = RandomNumberListGenerator.generate();
    }
    public Hint generateHint(Input userInput){
        int strike = findMatchedNumberAndPlace(userInput);
        int ball = findMatchedNumber(userInput) - strike;
        return new Hint(ball, strike);
    }

    private int findMatchedNumber(Input userInput){
        return (int) userInput
                .getBaseballNumberList()
                .stream()
                .filter(answer::contains)
                .count();
    }

    private int findMatchedNumberAndPlace(Input userInput){
        int matchedNumberAndPlace = 0;
        int inputIteratorNumber = 0;
        for(int answerNumber : answer){
            if(userInput.getBaseballNumberList().get(inputIteratorNumber)
                    == answerNumber){
                matchedNumberAndPlace++;
            }
            inputIteratorNumber++;
        }
        return matchedNumberAndPlace;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
