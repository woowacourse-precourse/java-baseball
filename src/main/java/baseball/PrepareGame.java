package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PrepareGame {
    public List<Integer> setComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!isEachDigit(computer, randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private Boolean isEachDigit(List<Integer> digitList, int digitNumber) {
        return digitList.contains(digitNumber);
    }

    public String setUserNumber() {
        String userNumber = Console.readLine();
        if (!isNumber(userNumber) || !isThreeDigitNumber(userNumber)) {
            throw new IllegalArgumentException("Please enter the correct value");
        }
        return userNumber;
    }

    public String setUserNumberForTest(String userNumber) {
        if (!isNumber(userNumber) || !isThreeDigitNumber(userNumber)) {
            throw new IllegalArgumentException("Please enter the correct value");
        }
        return userNumber;
    }

    private Boolean isNumber(String number) {
        return number.matches("-?\\d+");
    }

    private Boolean isThreeDigitNumber(String number) {
        return number.length() == 3;
    }

    public List<Integer> userNumberToList(String userNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (int index = 0; index < userNumber.length(); index++) {
            userNumberList.add(userNumber.charAt(index) - '0');
        }
        return userNumberList;
    }

    public Boolean isGameExit() {
        String gameOver = Console.readLine();
        if (gameOver.equals("1")) {
            return true;
        }
        return false;
    }

    public Boolean isGameExitForTest(String gameOver) {
        if (gameOver.equals("1")) {
            return true;
        }
        return false;
    }
}
