package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final List<Integer> answer;
    private List<Integer> inputList;
    private HashMap<String, Integer> counts;

    public Computer() {
        this.answer = setAnswer();
        this.counts = new HashMap<>();
    }

    public Integer getStrikeCount() {
        return counts.get("strike");
    }

    public Integer getBallCount() {
        return counts.get("ball");
    }

    private List<Integer> setAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            addRandomNumber(answer);
        }
        return answer;
    }

    private static void addRandomNumber(List<Integer> answer) {
        Integer randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    public Result getResultOfInput(String input) {
        this.inputList = stringToIntegerList(input);
        this.counts = initializeCounts();

        for (int index = 0; index < 3; index++) {
            getStrikeOrBallCount(index);
        }

        if (getStrikeCount() == 3) {
            return Result.ANSWER;
        } else if (getStrikeCount() == 0 && getBallCount() == 0) {
            return Result.NOTHING;
        } else {
            return Result.STRIKEBALL;
        }
    }

    private void getStrikeOrBallCount(int index) {
        if (answer.get(index).equals(inputList.get(index))) {
            counts.put("strike", getStrikeCount() + 1);
        } else if (answer.contains(inputList.get(index))) {
            counts.put("ball", getBallCount() + 1);
        }
    }

    private HashMap<String, Integer> initializeCounts() {
        counts.put("strike", 0);
        counts.put("ball", 0);
        return counts;
    }

    private static List<Integer> stringToIntegerList(String string) {
        return Stream.of(string.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
