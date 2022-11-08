package baseball.model.numbergenerator;

import baseball.model.numbers.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NextStepNumberGenerator implements NumberGenerator {

    @Override
    public Numbers generateRandomNumber(int count) {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < count){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        Numbers answerNumbers = new Numbers(answer);

        return answerNumbers;
    }
}