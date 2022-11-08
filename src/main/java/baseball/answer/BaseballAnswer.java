package baseball.answer;

import baseball.gametype.BaseballType;
import basedomain.answer.Answer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    @Override
    public boolean isCorrect(int candidate) {
        return IntStream.range(0, answer.size())
                .filter(index -> answer.get(index) == digitOfNumber(index+1, candidate))
                .count() == answer.size();
    }

    private int digitOfNumber(int location, int number) {
        int countOfDigit = (int) (Math.log10(number)) + 1;
        return number / (int) Math.pow(10, countOfDigit - location) % 10;
    }
}
