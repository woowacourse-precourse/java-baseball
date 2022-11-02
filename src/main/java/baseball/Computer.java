package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.Constant.NUMBER_CNT;

public class Computer {
    private List<Integer> answer; //answer 3개로 구성되어있는건 검증 못할까>?
    
    public void putAnswer(List<Integer> numbers) {
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
        answer = new ArrayList<>();
        answer.add(numbers.get(0));
        answer.add(numbers.get(1));
        answer.add(numbers.get(2));
    }


    public List<Integer> returnResult(List<Integer> guessNumbers) { // 반환타입 List가 맞을까, []가 맞을까
        List<Integer> result = new ArrayList<>();
        Integer strikeCnt = 0;
        Integer ballCnt = 0;

        if (guessNumbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException("세 개의 숫자로 추리해야 합니다");
        }
        // 숫자들을 한개씩 for문 돈다
        // 첫 번째 숫자를 비교
        // 두 번째 숫자를 비교
        // 세 번째 숫자를 비교
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
