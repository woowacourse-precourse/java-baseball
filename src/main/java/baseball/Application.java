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

    static void checkLength(String str, int num) {
        if (str.length() != num) {
            throw new IllegalArgumentException();
        }
    }

    static void checkRange(String strNumber, int index) {
        if (strNumber.charAt(index) - '0' < 1 || strNumber.charAt(index) - '0' > 9) {
            throw new IllegalArgumentException();
        }
    }

    static void checkDuplication(String strNumber) {
        if (strNumber.charAt(0) == strNumber.charAt(1) || strNumber.charAt(0) == strNumber.charAt(2)
                || strNumber.charAt(1) == strNumber.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String strNumber = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        checkLength(strNumber, 3);
        for (int i = 0; i < strNumber.length(); i++) {
            checkRange(strNumber, i);
        }
        checkDuplication(strNumber);
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

    static int replayGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int cmd = Integer.parseInt(Console.readLine());
        if (cmd != 1 && cmd != 2) {
            throw new IllegalArgumentException();
        }
        return cmd;
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
        if (strike == 3) {
            return replayGame();
        }
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
        if (cmd == 1) {
            run();
        } else if (cmd == 2) {
            return;
        }
    }

    public static void main(String[] args) {
        run();
    }
}
