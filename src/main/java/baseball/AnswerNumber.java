
package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class AnswerNumber {
    private List<Integer> answerNumberList;

    public AnswerNumber() {
        this.answerNumberList = new ArrayList<>();
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

    public void RandomNumber() {
        HashSet<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < Game.BALLSIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
            numbers.add(num);

        }
        answerNumberList = new ArrayList<>(numbers);
    }

}
