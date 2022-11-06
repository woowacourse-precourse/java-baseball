package baseball.validator;

import java.util.List;

public class Referee implements Validator {

    private List<Integer> answer;

    @Override
    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(List<Integer> input) {
        validateAnswer(input);

        int strike = 0;
        int ball = 0;
        for(int i=0;i<answer.size();i++){
            if(answer.contains(input.get(i))){
                if(answer.get(i) == input.get(i)){
                    strike++;
                }
                else{
                    ball++;
                }
            }
        }
        return false;
    }

    @Override
    public void validateAnswer(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("입력값의 길이는 무조건 3이여야 합니다.");
        }
        if (!isInRange(input)) {
            throw new IllegalArgumentException("입력값의 범위는 1 이상 9 이하여야 합니다.");
        }
    }

    private boolean isInRange(List<Integer> input) {
        for (int num : input) {
            if (!(num >= 1 && num <= 9)) {
                return false;
            }
        }
        return true;
    }
}
