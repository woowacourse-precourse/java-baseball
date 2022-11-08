package baseball;

import java.util.List;

public class NumberBaseball {
    private List<Integer> CorrectAnswer;

    public List<Integer> getAnswer(){
        return CorrectAnswer;
    }

    public void setAnswer(int first, int second, int third){
        CorrectAnswer.set(0, first);
        CorrectAnswer.set(1, second);
        CorrectAnswer.set(2, third);
    }

}
