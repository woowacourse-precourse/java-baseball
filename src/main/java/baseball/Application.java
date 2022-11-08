package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Game.play;
import static baseball.Validation.hasOnlyNumber;
import static baseball.Validation.isValidLength;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static final int NUMBER_OF_DIGIT = 3;

    public static void main(String[] args) {
        boolean isContinue = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(isContinue) {
            List<String> computerNumber = getComputerNumber();

            play(computerNumber);

            isContinue = getRestartFromUser();
        }
    }

    private static ArrayList<String> getComputerNumber() {
        ArrayList<String> computerNumber = new ArrayList<>();

        while (computerNumber.size() < NUMBER_OF_DIGIT) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }

        return computerNumber;
    }

    private static boolean getRestartFromUser() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        List<String> userInput = new ArrayList<>(Arrays.asList(readLine().split("")));
        if (!isValidLength(userInput, 1) || !hasOnlyNumber(userInput)) {
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
}
