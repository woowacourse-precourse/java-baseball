package baseball.infrastructure.ball;

import baseball.domain.ball.service.BallFactory;
import baseball.global.utils.message.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallFactoryImpl implements BallFactory {

    @Override
    public List<Integer> getRandomNumbers() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() != 3) {
            final int number = Randoms.pickNumberInRange(Number.RANDOM_MIN_VALUE, Number.RANDOM_MAX_VALUE);
            addListIfNotDuplicateNumber(answer, number);
        }
        return answer;
    }

    @Override
    public List<Integer> convertStringToIntegerList(String number) {
        return Stream.of(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private void addListIfNotDuplicateNumber(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }

}
