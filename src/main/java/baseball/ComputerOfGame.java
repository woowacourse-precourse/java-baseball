package baseball;
import static Config.BaseResponseStatus .*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerOfGame {
    private List<Integer> answer;

    public ComputerOfGame() {
        this.answer = new ArrayList<>(NUMBER_LENGTH);
    }
    public void makeAnswer() {
        List<Integer> randomNumber;
        do {
            randomNumber = new ArrayList<>();
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                randomNumber.add(Randoms.pickNumberInRange(START_OF_NUMBER, END_OF_NUMBER));
            }
        } while (!isUnique(randomNumber) || !isRightLength(randomNumber));

        answer = new ArrayList<>(randomNumber);
    }
    private boolean isUnique(List<Integer> randomNumber) {
        Set<Integer> randomDigits = new HashSet<>(randomNumber);
        return randomDigits.size() == 3;
    }
    private boolean isRightLength(List<Integer> randomNumber) {
        return randomNumber.size() == 3;
    }

}
