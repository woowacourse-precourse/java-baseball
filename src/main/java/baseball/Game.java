package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Integer> setComputersRandomAnswer() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int addNumber = getRandomIntegerExcludeInList(answer);
            answer.add(addNumber);
        }

        return answer;
    }

    private int getRandomIntegerExcludeInList(List<Integer> answer) {
        int number;

        do {
            number = Randoms.pickNumberInRange(1, 9);
        } while (answer.contains(number));

        return number;
    }
}
