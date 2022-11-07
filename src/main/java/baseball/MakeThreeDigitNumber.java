package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class MakeThreeDigitNumber {

    public ArrayList<String> computerSelectedNumber() {
        ArrayList<String> randomSelectedNumbers = new ArrayList<>();

        while (randomSelectedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String stringRandomNumber = String.valueOf(randomNumber);

            if (!randomSelectedNumbers.contains(stringRandomNumber)) {
                randomSelectedNumbers.add(stringRandomNumber);
            }
        }

        return randomSelectedNumbers;
    }

}

