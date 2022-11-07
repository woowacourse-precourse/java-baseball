package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<String> userSelectedNumber() {
        System.out.print("숫자를 입력하세요 : ");
        String inputNumbers = Console.readLine();
        String[] inputList = inputNumbers.split("");
        return new ArrayList<>(Arrays.asList(inputList));
    }

}

