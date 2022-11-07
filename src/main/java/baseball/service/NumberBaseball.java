package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberBaseball {
    private List<Integer> answer;

    public NumberBaseball() {
        generateAnswerNumber();
    }

    public void generateAnswerNumber() {
        answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    //getter for test code
    public List<Integer> getAnswer() {
        return answer;
    }
}
