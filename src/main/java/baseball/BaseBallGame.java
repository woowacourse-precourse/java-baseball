package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private int answerLength;

    private final int NOT_INCLUDED = 0;

    private int[] answer;

    public BaseBallGame(int answerLength){
        this.answerLength = answerLength;
    }

    public void useCustomAnswer(int[] baseballGameAnswer) {
        this.answer = baseballGameAnswer;
    }

    public void useGeneratedAnswer() {
        this.answer = generateBaseballGameAnswer();
    }

    private int[] generateBaseballGameAnswer() {
        StringBuilder sb = new StringBuilder();

        int[] baseballGameAnswer = new int[10];

        int order = 1;

        while (sb.length() < answerLength) {
            int generatedNumber = Randoms.pickNumberInRange(1, 9);

            if (baseballGameAnswer[generatedNumber] == NOT_INCLUDED) {
                sb.append(generatedNumber);
                baseballGameAnswer[generatedNumber] = order++;
            }
        }

        return baseballGameAnswer;
    }

    public BaseballGameResultDto submitAnswer(String userAnswer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answerLength; i++) {
            int target = answer[userAnswer.charAt(i) - '0'];

            if(target==0){
                continue;
            }

            if (target == i + 1) {
                strike++;
            }

            if (target != i + 1) {
                ball++;
            }
        }

        if(strike==answerLength){
            return new BaseballGameResultDto(strike, ball, true);
        }
        return new BaseballGameResultDto(strike, ball, false);
    }
}
