package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private final int ZERO = 0;
    private final int NUMBER_LENGTH = 3;
    private final List<Integer> answer_number;

    public Game() {
        this.answer_number = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (number.contains(randomNumber)) continue;
            number.add(randomNumber);
        }
        return number;
    }

    public boolean validateAnswer_number() {
        return answer_number.stream()
                .allMatch(num -> num > ZERO)
            && answer_number.stream()
                .distinct()
                .count() == NUMBER_LENGTH;
    }

    public int getCountOfStrike(List<Integer> predict_number) {
        return (int) IntStream.range(ZERO, NUMBER_LENGTH)
                .mapToObj(index -> List.of(answer_number.get(index), predict_number.get(index)))
                .filter(this::checkAnswerAndPredictOnebyOne)
                .count();
    }

    private boolean checkAnswerAndPredictOnebyOne(List<Integer> answer_and_predict_num) {
        return answer_and_predict_num.get(0).equals(answer_and_predict_num.get(1));
    }

    public int getCountOfBall(List<Integer> player_number, int strike) {
        return (int) player_number.stream()
                .filter(answer_number::contains)
                .count() - strike;
    }
}
