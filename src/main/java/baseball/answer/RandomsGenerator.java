package baseball.answer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * camp.nextstep.edu.missionutils.Randoms에 의존하는 구현체
 */
public class RandomsGenerator implements AnswerGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }

        return answerList;
    }

    /**
     * generateWithSet()은 Randoms.pickNumberInRange()을 사용하지 않는 요구사항 위반<br>
     * generate()를 사용해야 함
     */
    @Deprecated
    public List<Integer> generateWithSet() {
        Set<Integer> answerSet = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> answerList = new ArrayList<>();

        for (int sequence = 1; sequence <= 3; ++sequence) {
            int curAnswer = Randoms.pickNumberInList(new ArrayList<>(answerSet));
            answerSet.remove(curAnswer);
            answerList.add(curAnswer);
        }

        return answerList;
    }

}
