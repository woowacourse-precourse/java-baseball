package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> answer_number;

    public Game() {
        this.answer_number = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (number.contains(randomNumber)) continue;
            number.add(randomNumber);
        }
        return number;
    }

    public boolean validateAnswer_number() {
        return answer_number.stream()
                            .allMatch(num -> num > 0 && num < 10)
            && answer_number.stream()
                            .distinct()
                            .count() == 3;
    }

}
