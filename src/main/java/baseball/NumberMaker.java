package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {
    private String computerNumber = "";
    private String userNumber = "";

    private void makeComputerNumber() {
        int pickedNumber = 0;
        String pickedNumberToString = "";
        computerNumber = "";
        while (computerNumber.length() < 3) {
            pickedNumber = Randoms.pickNumberInRange(1, 9);
            pickedNumberToString = Integer.toString(pickedNumber);
            if (computerNumber.contains(pickedNumberToString)) {
                continue;
            }
            computerNumber += pickedNumber;
        }
    }

    private void makeUserNumber() {
        String temp = Console.readLine();
        userNumber = temp;
    }

    public String getComputerNumber() {
        makeComputerNumber();
        ValidateGameComponent.validateNumber(computerNumber);
        return computerNumber;
    }

    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        makeUserNumber();
        ValidateGameComponent.validateNumber(userNumber);
        return userNumber;
    }
}
