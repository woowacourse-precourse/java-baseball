package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameCycle {
    public String drawNumber() {
        List<String> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(String.valueOf(number));
            }
        }
        String randomNumber = String.join("", randomNumbers);
        return randomNumber;
    }
    public String inputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
    public boolean numberLengthIsThree(String number) {
        if (number.length() != 3) throw new IllegalArgumentException();
        return true;
    }
    public boolean numberIsDigit(String number) {
        char[] numberCharArray = number.toCharArray();
        for (char tmpChar : numberCharArray) {
            if (!Character.isDigit(tmpChar)) throw new IllegalArgumentException();
        }
        return true;
    }
}
