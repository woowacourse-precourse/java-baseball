package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean isLength(String inputNum) {
        if (inputNum.length() != 3) {
            return false;
        }
        return true;
    }

    public static boolean isDiff(String inputNum) {
        for (int i = 0; i < inputNum.length() - 1; i++) {
            if (inputNum.charAt(i) == inputNum.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRange(String inputNum) {
        for (int i = 0; i < inputNum.length(); i++) {
            int number = Character.getNumericValue(inputNum.charAt(i));
            if (number < 1 || number > 10) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String inputNum) {
        if (isDiff(inputNum) && isLength(inputNum) && isRange(inputNum)) {
            return true;
        }
        return false;
    }

    public static List<Integer> computerPick() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> userPick() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        if (isValid(inputNum)) {
            String[] tempNum = inputNum.split("");
            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < tempNum.length; i++) {
                user.add(Integer.valueOf(tempNum[i]));
            }
            return user;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void compare(List<Integer> computerNum, List<Integer> userNum) {

    }

    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
        List<Integer> computerNum = computerPick();
        try {
            List<Integer> userNum = userPick();
            compare(computerNum, userNum);
        } catch(IllegalArgumentException e) {
            return;
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
