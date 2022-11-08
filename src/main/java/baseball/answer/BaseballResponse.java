package baseball.answer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballResponse {

    private int strike = 0;
    private int ball = 0;

    private final String NOTHING_STRING = "낫싱";
    private final String BALL_STRING = "볼";
    private final String STRIKE_STRING = "스트라이크";

    public BaseballResponse(List<Integer> answer, int candidate) {
        List<Integer> candidateIntegerList = intToIntegerList(candidate);
        strike = countStrike(answer, candidateIntegerList);
        ball = countBall(answer, candidateIntegerList);
    }

    private List<Integer> intToIntegerList(int number) {
        List<Integer> integerList = new ArrayList<>();
        int countOfDigits = (int) (Math.log10(number)) + 1;
        for (int count = countOfDigits; count >= 1; count--) {
            int digitOfNumber = number / (int) Math.pow(10, count -1) % 10;
            integerList.add(digitOfNumber);
        }
        return integerList;
    }

    private int countStrike(List<Integer> answer, List<Integer> candidate) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> answer.get(index) == candidate.get(index))
                .count();
    }

    private int countBall(List<Integer> answer, List<Integer> candidate) {
        return (int) IntStream.range(0, candidate.size())
                .filter(index -> isInListAndIndexNotMatched(answer, candidate.get(index), index))
                .count();
    }

    private boolean isInListAndIndexNotMatched(List<Integer> list, int number, int index) {
        return IntStream.range(0, list.size())
                .filter(listIndex -> listIndex != index)
                .filter(listIndex -> list.get(listIndex) == number)
                .count() != 0;
    }

    public String response() {
        if (isNothing()) {
            return NOTHING_STRING;
        }
        if (ball != 0 && strike != 0) {
            return responseBall() + " " + responseStrike();
        }
        if (ball != 0) {
            return responseBall();
        }
        return responseStrike();
    }

    private String responseBall() {
        return ball + BALL_STRING;
    }

    private String responseStrike() {
        return strike + STRIKE_STRING;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
