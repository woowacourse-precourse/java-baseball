package baseball.domain.baseballAlgorithm;

import static baseball.domain.baseballAlgorithm.BallAndStrike.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballAlgorithmImpl implements BaseballAlgorithm {

    @Override
    public String checkBaseballResult(List<Integer> randomNumber, String userInput) {
        List<String> inputNumbers = new ArrayList<>(List.of(userInput.split("")));
        for (int i = 0; i < inputNumbers.size(); i++) {
            int number = Integer.parseInt(inputNumbers.get(i));
            if (randomNumber.contains(number)) {
                countStrikeAndBall(randomNumber, inputNumbers, number);
            }
        }
        String baseballResultMessage = makeBaseballResultMessage();
        clearCount();
        return baseballResultMessage;
    }

    private String makeBaseballResultMessage() {
        if (ball.getCount() == 0 && strike.getCount() == 0) {
            return "낫싱";
        }
        if (ball.getCount() != 0 && strike.getCount() == 0) {
            return ball.getCount() + "볼";
        }
        if (ball.getCount() == 0 && strike.getCount() != 0) {
            return strike.getCount() + "스트라이크";
        }
        return ball.getCount() + "볼 " + strike.getCount() + "스트라이크";
    }

    private void countStrikeAndBall(List<Integer> randomNumber, List<String> inputNumber, int number) {
        if (randomNumber.indexOf(number) == inputNumber.indexOf(String.valueOf(number))) {
            strike.setCount(strike.getCount()+1);
            return;
        }
        ball.setCount(ball.getCount()+1);
    }

    private void clearCount() {
        ball.setCount(0);
        strike.setCount(0);
    }
}
