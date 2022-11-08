package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer() {

        int randomNumbersSize = 3;
        int startRange = 1;
        int endRange = 9;
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Set<Integer> setRandomNumbers = new HashSet<>();
        String setNumber = "";

        while (setRandomNumbers.size() < randomNumbersSize) {

            int randomNumber = Randoms.pickNumberInRange(startRange, endRange);

            if (!setRandomNumbers.contains(randomNumber)) {
                setRandomNumbers.add(randomNumber);
                randomNumbers.add(randomNumber);
            }
        }

        for (int i = 0; i < randomNumbersSize; i++) {
            setNumber += randomNumbers.get(i).toString();
        }

        this.answer = setNumber;
    }

}
