package baseball;

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
}
