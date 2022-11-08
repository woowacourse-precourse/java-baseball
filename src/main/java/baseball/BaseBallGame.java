package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

public class BaseBallGame {
    private int answerLength;

    private final int NOT_INCLUDED = 0;

    private int[] answer;

    public BaseBallGame(int answerLength) {
        this.answerLength = answerLength;
    }

    public void useCustomAnswer(int[] baseballGameAnswer) {
        this.answer = baseballGameAnswer;
    }

    public void useGeneratedAnswer() {
        this.answer = generateBaseballGameAnswer();
    }

    private int[] generateBaseballGameAnswer() {
        int[] baseballGameAnswer = new int[10];

        int order = 1;

        while (order <= answerLength) {
            int generatedNumber = Randoms.pickNumberInRange(1, 9);

            if (baseballGameAnswer[generatedNumber] == NOT_INCLUDED) {
                baseballGameAnswer[generatedNumber] = order++;
            }
        }

        return baseballGameAnswer;
    }

    public BaseballGameResultDto submitAnswer(String number) {
        String regex = "^[0-9]{" + answerLength + "}";
        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다");
        }
        boolean[] isExists = new boolean[10];

        for (int i = 0; i < number.length(); i++) {
            int currentIndex = number.charAt(i) - '0';
            if (isExists[currentIndex]) {
                throw new IllegalArgumentException("중복된 수가 입력되었습니다");
            }
            isExists[currentIndex] = true;
        }

        return matchAnswer(number);
    }

    public BaseballGameResultDto matchAnswer(String userAnswer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answerLength; i++) {
            int target = answer[userAnswer.charAt(i) - '0'];

            if (target == 0) {
                continue;
            }

            if (target == i + 1) {
                strike++;
            }

            if (target != i + 1) {
                ball++;
            }
        }

        return new BaseballGameResultDto(strike, ball);

    }
}
