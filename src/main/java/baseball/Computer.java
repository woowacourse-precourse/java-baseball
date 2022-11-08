package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {
    private List<Integer> answerNumber;

    public Computer() {
        generateNewRandomAnswer();
    }

    public List<Integer> getAnswerNumber() {
        return answerNumber;
    }

    private void generateNewRandomAnswer() {
        answerNumber = new ArrayList<>();

        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }

        if (!isValidNumber(answerNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidNumber(List<Integer> numbers) {
        if (numbers.size() != 3) {
            return false;
        }

        return numbers.stream().allMatch(number -> {
            if (Collections.frequency(numbers, number) > 1) {
                return false;
            }
            return number >= 1 && number <= 9;
        });
    }

    public List<Integer> compareWithAnswer(List<Integer> numbers) {
        if (!isValidNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        return Arrays.asList(getBallCnt(numbers), getStrikeCnt(numbers));
    }

    private Integer getStrikeCnt(List<Integer> numbers) {
        return (int) IntStream.range(0, 3).boxed().filter(i -> numbers.get(i).equals(answerNumber.get(i))).count();
    }

    private Integer getBallCnt(List<Integer> numbers) {
        Integer cntBall = 0;
        if (numbers.get(0) == answerNumber.get(1) || numbers.get(0) == answerNumber.get(2)) {
            cntBall++;
        }
        if (numbers.get(1) == answerNumber.get(0) || numbers.get(1) == answerNumber.get(2)) {
            cntBall++;
        }
        if (numbers.get(2) == answerNumber.get(0) || numbers.get(2) == answerNumber.get(1)) {
            cntBall++;
        }
        return cntBall;
    }
}
