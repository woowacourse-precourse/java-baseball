package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Const.NUMBER_LENGTH;


public class AnswerGenerator {

    private int[] answer;

    public AnswerGenerator() {
        answer  = new int[NUMBER_LENGTH];
    }

    public int[] getAnswer() {
        return answer;
    }

    public void generateAnswer()  {
        int index=0;

        while (index < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!isContain(randomNumber)) {
                answer[index]=randomNumber;
                index++;
            }
        }
    }

    private boolean isContain(int randomNumber) {
        for (int i : answer) {
            if (i == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
