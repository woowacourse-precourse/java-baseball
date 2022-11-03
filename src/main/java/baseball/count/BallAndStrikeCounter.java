package baseball.count;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.MapKeyStorage.BALL_KEY;
import static baseball.MapKeyStorage.STRIKE_KEY;

public class BallAndStrikeCounter {

    public Map<String, Integer> checkBallAndStrikeCount(List<Integer> answer, String inputValue) {
        List<Integer> inputNumber = inputValueToList(inputValue);

        int ballCount = checkBall(answer, inputNumber);
        int strikeCount = checkStrike(answer, inputNumber);

        return Map.of(
                BALL_KEY, ballCount,
                STRIKE_KEY, strikeCount
        );
    }

    private List<Integer> inputValueToList(String inputValue) {
        return IntStream.range(0, 3)
                .mapToObj(i -> Integer.parseInt(inputValue.substring(i, i + 1)))
                .collect(Collectors.toList());
    }

    private int checkBall(List<Integer> answer, List<Integer> inputNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> answer.contains(inputNumber.get(i)))
                .filter(i -> !answer.get(i).equals(inputNumber.get(i)))
                .count();
    }

    private int checkStrike(List<Integer> answer, List<Integer> inputNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> answer.get(i).equals(inputNumber.get(i)))
                .count();
    }
}
