package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.Constant.*;

public class Computer {
    private List<Integer> answer;

    public void putAnswer() {
        List<Integer> numbers = makeAnswer();
        validateAnswer(numbers);
        answer = numbers;
        System.out.println("(임시) 숫자야구의 정답 : " + answer); // TODO: 마지막에 삭제
    }

    private void validateAnswer(List<Integer> numbers) {
        if(numbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException("입력값의 크기는 3개여야 합니다");
        }
        HashSet<Integer> resultDuplicateRemoved = new HashSet<>(numbers);
        if(!(resultDuplicateRemoved.size() == NUMBER_CNT)) {
            throw new IllegalArgumentException("값이 중복되서는 안됩니다");
        }
        Integer resultRangeValidated = (int) numbers.stream().filter(number -> 1 <= number && number <= 9).count();
        if (resultRangeValidated != NUMBER_CNT) {
            throw new IllegalArgumentException("1이상 9이하의 숫자만 들어갈 수 있습니다");
        }
    }

    protected List<Integer> makeAnswer() {
        return RandomGenerator.makeNotDuplicatedRandomNumbers(NUMBER_CNT, MIN_RANGE, MAX_RANGE);
    }

    public List<Integer> returnResult(List<Integer> guessNumbers) { // TODO 고민 Point : 반환타입 List가 맞을까, []가 맞을까
        List<Integer> result = new ArrayList<>();
        Integer strikeCnt = 0;
        Integer ballCnt = 0;

        if (guessNumbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException("세 개의 숫자로 추리해야 합니다");
        }

        for (int i = 0; i < 3; i++) {
            //입력자리수와 answer의 자리수가 같다면 -> strike
            if (guessNumbers.get(i) == answer.get(i)) {
                strikeCnt += 1;
                continue;
            }
            // ball
            if (answer.contains(guessNumbers.get(i))) {
                ballCnt += 1;
            }
        }
        result.add(strikeCnt);
        result.add(ballCnt);
        return result;
    }

}
