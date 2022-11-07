package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        startGame();
        List<Integer> computerNumber = generateComputerNumber();
        String userNumber = inputUserNumber();
    }

    static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    static String inputUserNumber() {
        String userNumber = Console.readLine();
        return userNumber;
    }

    static boolean isValidate(String userNumber) {
        Set<Integer> eachNumber = new HashSet<>();
        for (int digit = 0; digit < userNumber.length(); digit++) {
            if (eachNumber.contains(userNumber.charAt(digit) - '0'))
                return false;
            eachNumber.add(userNumber.charAt(digit) - '0');
        }
        return true;
    }
}
