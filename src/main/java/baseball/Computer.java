package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private List<Character> computerAnswer;

    public void createAnswer() {
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Character randomNumberChar = (char)(randomNumber + '0');

            if (!computerAnswer.contains(randomNumberChar)) {
                computerAnswer.add(randomNumberChar);
            }
        }
    }
}
