package baseball.answer;

import baseball.gametype.BaseballType;
import baseball.response.BaseballResponse;
import basedomain.answer.Answer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballAnswer extends Answer {

    private List<Integer> answer;

    public BaseballAnswer(BaseballType baseballGameType) {
        this.answer = new ArrayList<>();
        makeAnswer(baseballGameType.getNumberOfDigit());
    }

    private void makeAnswer(int numberOfDigit) {
        for (int count = 1; count <= numberOfDigit; count++) {
            answer.add(nonOverlappingNumber());
        }
    }

    private int nonOverlappingNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (isInAnswer(randomNumber)){
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

    private boolean isInAnswer(int number) {
        return answer.stream()
                .map(answerNumber -> answerNumber == number)
                .reduce(false, (isEqual1, isEqual2) -> isEqual1 || isEqual2);
    }

    @Override
    public String response(int candidate) {
        return new BaseballResponse(answer, candidate).response();
    }
}
