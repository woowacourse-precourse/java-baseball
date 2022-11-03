package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Character> computerNumber;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void initComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            Character randomNumber = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static int checkStrike(String userInput) {
        int strikeCount = 0;

        for (int place = 0; place < userInput.length(); place++) {
            Character computerNum = computerNumber.get(place);
            Character userNum = userInput.charAt(place);

            if(computerNum.equals(userNum)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
