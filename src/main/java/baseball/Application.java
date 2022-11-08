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
        return !(100 <= userNumber && userNumber <= 999);
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

    public static List<Integer> splitIntToList(int originalInt) {
        List<Integer> splitList = new ArrayList<>();
        while (originalInt > 0) {
            int digit = originalInt % 10;
            splitList.add(0, digit);
            originalInt /= 10;
        }
        return splitList;
    }

    public static List<Integer> callReferee(List<Integer> randomNumberList, List<Integer> userNumberList) {
        int strike = 0;
        int ball = 0;
        List<Boolean> isBallList = new ArrayList<>(List.of(false, false, false, false, false, false, false, false, false, false));

        for (int i = 0; i < 3; i++) {
            if (randomNumberList.get(i).equals(userNumberList.get(i))) {
                strike++;
            }
            else {
                isBallList.set(randomNumberList.get(i), true);
            }
        }
        for (int userNumber: userNumberList) {
            if(isBallList.get(userNumber)) {
                ball++;
            }
        }
        return new ArrayList<>(List.of(strike, ball));
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumberList = makeRandomNumber();
        int userNumber = askNumber();
        boolean lengthViolationFlag = checkNumberLength(userNumber);
        boolean duplicationFlag = checkDuplication(userNumber);
        if (lengthViolationFlag || duplicationFlag) {
            throw new IllegalArgumentException();
        }
        List<Integer> userNumberList = splitIntToList(userNumber);
        List<Integer> strikeBall = callReferee(randomNumberList, userNumberList);
    }
}