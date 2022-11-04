package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        computer = createComputerNumber();

        String userNumberString = Console.readLine();
        String[] userNumberStringList = userNumberString.split("");

        if (isWrongInput(userNumberStringList)) {
            throw new IllegalArgumentException("잘못된 입력값을 입력하셨습니다.");
        }

        List<Integer> user = listToArrayList(userNumberStringList);

    }

    public static List<Integer> createComputerNumber() {
        List<Integer> userNumber = new ArrayList<>();

        while (userNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!userNumber.contains(randomNumber)) {
                userNumber.add(randomNumber);
            }
        }

        return userNumber;
    }

    public static List<Integer> listToArrayList(String[] userNumberStringList) {
        List<Integer> userNumberIntegerList = new ArrayList<>();

        for (int i = 0; i < userNumberStringList.length; i++) {
            userNumberIntegerList.add(Integer.parseInt(userNumberStringList[i]));
        }

        return userNumberIntegerList;
    }

    public static boolean isWrongInput (String[] userNumberStringList) {
        if (
                checkIntegerOrCharacter(userNumberStringList)
                        || checkInputLength(userNumberStringList)
                        || checkSameNumbers(userNumberStringList)) {
            return true;
        }

        return false;
    }

    public static boolean checkIntegerOrCharacter(String[] userNumberStringList) {
        for (int i = 0; i < userNumberStringList.length; i++) {
            if (!Character.isDigit(userNumberStringList[i].charAt(0))) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkInputLength(String[] userNumberStringList) {
        if (userNumberStringList.length > 3 || userNumberStringList.length < 1) {
            return true;
        }

        return false;
    }

    public static boolean checkSameNumbers(String[] userNumberStringList) {
        List<String> haveNumberList = new ArrayList<>();

        for (int i = 0; i < userNumberStringList.length; i++) {
            if (haveNumberList.contains(userNumberStringList[i])) {
                return true;
            }
            else {
                haveNumberList.add(userNumberStringList[i]);
            }
        }

        return false;
    }

}
