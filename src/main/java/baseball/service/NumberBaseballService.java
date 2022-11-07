package baseball.service;

import baseball.dto.StrikeBallCountDto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballService {
    private List<Integer> answer;

    public NumberBaseballService() {
        initAnswerNumber();
    }

    public void initAnswerNumber() {
        answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public StrikeBallCountDto compareInputAndAnswer(int input) {
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> inputDigitList = parseIntegerToDigitList(input);

        for (int idx = 0; idx < inputDigitList.size(); idx++) {
            Integer inputDigit = inputDigitList.get(idx);
            Integer answerDigit = answer.get(idx);

            if (inputDigit.equals(answerDigit)) {
                strikeCount++;
            } else if (answer.contains(inputDigit)) {
                ballCount++;
            }
        }

        return new StrikeBallCountDto(strikeCount, ballCount);
    }

    private List<Integer> parseIntegerToDigitList(int num) {
        List<Integer> digitList = new ArrayList<>(3);

        while (num != 0) {
            digitList.add(num % 10);
            num /= 10;
        }

        if (digitList.size() != 3) {
            throw new IllegalArgumentException();
        }

        int temp = digitList.get(0);
        digitList.set(0, digitList.get(2));
        digitList.set(2, temp);

        return digitList;
    }

    //getter for test code
    public List<Integer> getAnswer() {
        return answer;
    }
}
