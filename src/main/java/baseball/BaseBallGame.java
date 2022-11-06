package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private final int BASEBALL_GAME_ANSWER_LENGTH = 3;
    private final int NOT_INCLUDED = 0;

    private int[] baseballGameAnswer;

    public void useCustomAnswer(int[] baseballGameAnswer) {
        this.baseballGameAnswer = baseballGameAnswer;
    }

    public void useGeneratedAnswer() {
        this.baseballGameAnswer = generateBaseballGameAnswer();
    }

    private int[] generateBaseballGameAnswer() {
        StringBuilder sb = new StringBuilder();

        int[] baseballGameAnswer = new int[10];

        int order = 1;

        while (sb.length() < BASEBALL_GAME_ANSWER_LENGTH) {
            int generatedNumber = Randoms.pickNumberInRange(1, 9);

            if (baseballGameAnswer[generatedNumber] == NOT_INCLUDED) {
                sb.append(generatedNumber);
                baseballGameAnswer[generatedNumber] = order++;
            }
        }

        return baseballGameAnswer;
    }


}
