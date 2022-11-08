package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void errorMessage() {
        System.out.println("IllegalArgumentException 발생!");
        System.out.println("어플리케이션을 종료합니다.");
    }
    static boolean checkLength(String str, int num) throws IllegalArgumentException {
        boolean result = true;
        try {
            if (str.length() != num) {
                result = false;
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage();
        }
        return result;
    }

    static boolean checkRange(String strNumber, int index) {
        boolean result = true;
        try {
            if (strNumber.charAt(index) - '0' < 1 || strNumber.charAt(index) - '0' > 9) {
                result = false;
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage();
        }
        return result;


    }

    static boolean getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String strNumber = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        if (!checkLength(strNumber, 3)) {
            return false;
        }
        for (int i = 0; i < strNumber.length(); i++) {
            if (!checkRange(strNumber, i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startMessage();
        List<Integer> computer = makeNumber();
        if (!getUserNumber()) {
            return;
        }
}
