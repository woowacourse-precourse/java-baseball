package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Counter {
    private Map<String, Integer> count = new HashMap<>();
    private List<Integer> input;
    private List<Integer> answer;
    private int ballCount;
    private int strikeCount;

    protected Counter(List<Integer> input, List<Integer> answer){
        this.input = input;
        this.answer = answer;
        this.countBall();
        this.countStrike();
    }

    protected Map<String, Integer> countBall(){
        this.ballCount = (int) answer.stream()
                .filter(inputData -> input.stream().anyMatch(Predicate.isEqual(inputData)))
                .count();

        count.put("ball",ballCount);
        return count;
    }

    protected Map<String, Integer> countStrike(){
        this.strikeCount = (int) IntStream.range(0, answer.size())
                .filter(i -> (answer.get(i) == input.get(i)))
                .count();

        count.replace("ball",ballCount - strikeCount);
        count.put("strike",strikeCount);

        return count;
    }

}
