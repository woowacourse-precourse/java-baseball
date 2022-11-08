package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import baseball.model.Baseball;
import java.util.ArrayList;
import java.util.List;


public class Computer {
    public Baseball createRandomBaseball() {
        List<Integer> randomDigit = getRandomNumber();
        return new Baseball(randomDigit);
    }

    public List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while(randomNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
        return randomNumber;
    }
}
