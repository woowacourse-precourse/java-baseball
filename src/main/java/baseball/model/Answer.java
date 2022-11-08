package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> answer;

    public List<Integer> getAnswer(){
        return this.answer;
    }

    public void generateRandomAnswer(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addIfUnique(answer, randomNumber);
        }
        this.answer = answer;
    }

    private void addIfUnique(List<Integer> answer, int randomNumber){
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
}
