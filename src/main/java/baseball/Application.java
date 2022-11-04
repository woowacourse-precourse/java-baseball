package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Game.play;
import static baseball.Validation.isExistOnlyNumber;
import static baseball.Validation.isValidLength;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;

        while(isContinue) {
            List<String> computerNumber = getComputerNumber();

            play(computerNumber);

            isContinue = getRestartFromUser();
        }
    }

    private static boolean getRestartFromUser() {
        List<String> userInput = new ArrayList<>(Arrays.asList(readLine().split("")));
        if (!isValidLength(userInput, 1) || !isExistOnlyNumber(userInput)) {
            throw new IllegalArgumentException();
        }

        int number = Integer.parseInt(userInput.get(0));
        if (number == 1) {
            return true;
        }

        if (number == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private static ArrayList<String> getComputerNumber() {
        ArrayList<String> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }

        return computerNumber;
    }
}
