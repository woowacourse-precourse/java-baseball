package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StrikeBall {
    private Map<String, Integer> count;
    private List<Integer> input;
    private List<Integer> answer;
    private int ballCount;
    private int strikeCount;

    public StrikeBall(List<Integer> input, List<Integer> answer){
        this.count = new HashMap<>();
        this.input = input;
        this.answer = answer;
    }

    public Map<String, Integer> getCount(){
        return this.count;
    }

    public int getBallCount(){
        return this.ballCount;
    }

    public int getStrikeCount(){
        return this.strikeCount;
    }

    public void countBall(){
        ballCount = (int) answer.stream()
                .filter(inputData -> input.stream().anyMatch(Predicate.isEqual(inputData)))
                .count();

        count.put("ball",ballCount);
    }

    public void countStrike(){
        strikeCount = (int) IntStream.range(0, answer.size())
                .filter(i -> (answer.get(i) == input.get(i)))
                .count();

        count.replace("ball",ballCount - strikeCount);
        count.put("strike",strikeCount);

        ballCount = count.get("ball");
    }

}
