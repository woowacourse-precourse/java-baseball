package baseball.infrastructure.ball;

import baseball.domain.ball.service.BallFactory;
import baseball.global.utils.message.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallFactoryImpl implements BallFactory {

    @Override
    public List<Integer> getRandomNumbers() {
        List<Integer> answer = new ArrayList<>();
        while(answer.size() != 3) {
            final int number = Randoms.pickNumberInRange(Number.RANDOM_MIN_VALUE, Number.RANDOM_MAX_VALUE);
            addListIfNotDuplicateNumber(answer, number);
        }
        return answer;
    }

    private void addListIfNotDuplicateNumber(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }

}
