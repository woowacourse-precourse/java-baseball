package baseball.domain.baseballAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class BaseballAlgorithmImpl implements BaseballAlgorithm {

    private int ballCount;
    private int strikeCount;

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
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + "볼";
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    private void countStrikeAndBall(List<Integer> randomNumber, List<String> inputNumber, int number) {
        if (randomNumber.indexOf(number) == inputNumber.indexOf(String.valueOf(number))) {
            strikeCount++;
            return;
        }
        ballCount++;
    }

    private void clearCount() {
        ballCount = 0;
        strikeCount = 0;
    }
}
