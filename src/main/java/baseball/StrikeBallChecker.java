package baseball;

import static baseball.RandomNumberProvider.MAX_SIZE_OF_LIST;
import static baseball.ResponseMsg.BALL;
import static baseball.ResponseMsg.NOTHING;
import static baseball.ResponseMsg.STRIKE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StrikeBallChecker {

    private final List<Integer> answer;

    StrikeBallChecker(List<Integer> answer) {
        this.answer = answer;
    }

    public String matchAnswer(List<Integer> userInput) {
        Map<String, Long> counter = new HashMap<>();

        counter.put(BALL.getMsg(), checkBall(userInput));
        counter.put(STRIKE.getMsg(), checkStrike(userInput));

        return getMessage(counter);
    }

    private long checkStrike(List<Integer> userInput) {
        return IntStream.range(0, MAX_SIZE_OF_LIST)
                .filter(i -> Objects.equals(userInput.get(i), answer.get(i)))
                .count();
    }


    private long checkBall(List<Integer> userInput) {
        return IntStream.range(0, MAX_SIZE_OF_LIST)
                .filter(i -> answer.contains(userInput.get(i)) & !Objects.equals(userInput.get(i), answer.get(i)))
                .count();
    }

    private String getMessage(Map<String, Long> counter) {
        String result = counter.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Entry.comparingByKey())
                .map(entry -> entry.getValue() + entry.getKey())
                .collect(Collectors.joining(" "));

        if (result.isEmpty()) {
            result = NOTHING.getMsg();
        }

        return result;
    }
}
