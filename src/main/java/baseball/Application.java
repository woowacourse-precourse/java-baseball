package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int askNumber() {
        String userNumberString = readLine();
        return Integer.parseInt(userNumberString);
    }

    public static boolean checkNumberLength(int userNumber) {
        return 100 <= userNumber && userNumber <= 999;
    }

    public static boolean checkDuplication(int userNumber) {
        List<Boolean> duplicationCheckList = new ArrayList<>(List.of(false, false, false, false, false, false, false, false, false, false));
        while (userNumber > 0) {
            int digit = userNumber % 10;
            if (duplicationCheckList.get(digit)) {
                return true;
            }
            duplicationCheckList.set(digit, true);
            userNumber /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = makeRandomNumber();
        int userNumber = askNumber();
        boolean falsyLengthFlag = checkNumberLength(userNumber);
        boolean duplicationFlag = checkDuplication(userNumber);
    }
}