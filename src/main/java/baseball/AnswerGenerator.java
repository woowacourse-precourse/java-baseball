package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {

    private final int NUMBER_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private int[] answer;

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
}
