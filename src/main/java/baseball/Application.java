package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static String makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.toString().replaceAll("[^0-9]", "");
    }

    static void errorMessage(String error) {
        System.out.printf("IllegalArgumentException 발생! : %s ", error);
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
            errorMessage("입력하신 숫자가 3자리가 아닙니다.");
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
            errorMessage("입력하신 숫자의 범위가 1~9가 아닙니다.");
        }
        return result;
    }

    static boolean checkDuplication(String strNumber) {
        boolean result = true;
        try {
            if (strNumber.charAt(0) == strNumber.charAt(1) || strNumber.charAt(0) == strNumber.charAt(2)
                    || strNumber.charAt(1) == strNumber.charAt(2)) {
                result = false;
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage("입력하신 숫자에 중복이 있습니다.");
        }
        return result;
    }

    static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String strNumber = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        if (!checkLength(strNumber, 3)) {
            return null;
        }
        for (int i = 0; i < strNumber.length(); i++) {
            if (!checkRange(strNumber, i)) {
                return null;
            }
        }
        if (!checkDuplication(strNumber)) {
            return null;
        }
        return strNumber;
    }

    static void resultMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        String result = "";
        if (ball != 0) {
            result += String.format("%s볼 ", ball);
        }
        if (strike != 0) {
            result += String.format("%s스트라이크", strike);
        }
        System.out.println(result);
    }

    static int compareNumber(String computer, int index, char num) {
        if (computer.charAt(index) == num) {
            return 1;
        } else if (computer.contains(String.valueOf(num))) {
            return 2;
        }
        return 0;
    }

    static int compare(String computer, String user) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < user.length(); i++) {
            if (compareNumber(computer, i, user.charAt(i)) == 1) {
                strike += 1;
            } else if (compareNumber(computer, i, user.charAt(i)) == 2) {
                ball += 1;
            }
        }
        resultMessage(strike, ball);
        return 0;
    }

    static void run() {
        startMessage();
        String computer = makeNumber();
        int cmd;
        while (true) {
            String user = getUserNumber();
            if (user == null) {
                return;
            }
            cmd = compare(computer, user);
            if (cmd != 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
