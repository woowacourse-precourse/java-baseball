package baseball.service;



import baseball.model.Hint;
import baseball.model.Input;
import java.util.List;

public class Service {
    private List<Integer> answer;

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

        List<Integer> inputList = userInput.getBaseballNumberList();
        int inputSize = inputList.size();
        int matchedNumberAndPlace = 0;
        for(int i = 0; i < inputSize; i++){
            matchedNumberAndPlace += isIdentical(answer.get(i), inputList.get(i));
        }
        return matchedNumberAndPlace;
    }

    private int isIdentical(int num1, int num2){
        if(num1 != num2){
            return 0;
        }
        return 1;
    }

    public void resetRandomAnswer(){
        answer = RandomNumberListGenerator.generate();
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
