package baseball.domain;

import baseball.util.GameInput;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final int MAX_NUMBER_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    private String answer;

    GameInput gameInput = GameInput.getInstance();

    public Computer() {
        answer = "";
    }

    public void generateAnswer() {
        this.answer = "";

        while (answer.length() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            String numberString = gameInput.convertIntToString(randomNumber);
            if (!answer.contains(numberString)) {
                answer += numberString;
            }
        }
    }

    public String getAnswer() {
        return this.answer;
    }
}
