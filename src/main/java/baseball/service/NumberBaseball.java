package baseball.service;

import baseball.dto.StrikeBallCountDto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberBaseball {
    private List<Integer> answer;

    public NumberBaseball() {
        generateAnswerNumber();
    }

    public void generateAnswerNumber() {
        answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public StrikeBallCountDto compareInputAndAnswer(List<Integer> input) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int idx = 0; idx < input.size(); idx++) {
            Integer inputDigit = input.get(idx);
            Integer answerDigit = answer.get(idx);

            if (inputDigit.equals(answerDigit)) {
                strikeCount++;
            } else if (answer.contains(inputDigit)) {
                ballCount++;
            }
        }

        return new StrikeBallCountDto(strikeCount, ballCount);
    }

    //getter for test code
    public List<Integer> getAnswer() {
        return answer;
    }
}
