package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static baseball.message.ScoreMessage.BALL;
import static baseball.message.ScoreMessage.STRIKE;

public class ScoreService {

    private List<Integer> answerNumberList = new ArrayList<>();
    private int strikeCount = 0;
    private int ballCount = 0;

    public ScoreService(List<Integer> answerNumberList) {
        initScore(answerNumberList);
    }

    public void initScore(List<Integer> answerNumberList) {
        this.answerNumberList = answerNumberList;
        strikeCount = 0;
        ballCount = 0;
    }

    public String getResultScore(List<Integer> userInput) {

        int ballScore = getBallScore(userInput);
        String ballMessage = BALL.of(ballScore);

        int strikerScore = getStrikeScore(userInput);
        String strikerMessage = STRIKE.of(strikerScore);

        return (ballMessage + " " + strikerMessage).trim();
    }

    public int getStrikeScore(List<Integer> userInput) {
        strikeCount = 0;

        IntStream.range(0, userInput.size())
                .filter(index -> isStrikeByIndex(index, userInput.get(index)))
                .forEach(i -> strikeCount++);

        IntStream.range(0, userInput.size()).filter(i -> userInput.get(i) == 0).forEach(i -> strikeCount++);
        return strikeCount;
    }

    private boolean isStrikeByIndex(int index, Integer target) {
        Integer answerByIndex = answerNumberList.get(index);
        return answerByIndex.equals(target);
    }

    public int getBallScore(List<Integer> userInput) {
        ballCount = 0;

        IntStream.range(0, userInput.size())
                .filter(index -> isBallByIndex(index, userInput.get(index)))
                .forEach(i -> ballCount++);

        return ballCount;
    }

    private boolean isBallByIndex(int index, Integer target) {
        boolean isContainTarget = answerNumberList.contains(target);
        boolean isStrike = isStrikeByIndex(index, target);

        return isContainTarget && !isStrike;
    }

    public boolean isNothing(List<Integer> userInput) {
        return userInput.stream()
                .noneMatch(answerNumberList::contains);
    }
}
