package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> answer;

    protected Answer(){
        this.answer = generateRandomAnswer();
    }

    protected List<Integer> getAnswer(){
        return answer;
    }

    protected List<Integer> generateRandomAnswer(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addIfUnique(answer, randomNumber);
        }
        return answer;
    }

    protected void addIfUnique(List<Integer> answer, int randomNumber){
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
}
