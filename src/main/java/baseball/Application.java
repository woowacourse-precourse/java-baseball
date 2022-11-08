package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String status = "";

        // 게임을 다시 시작하거나 종료하는 기능
        while (!status.equals("2")) {
            List<Integer> computerList = new ArrayList<>();
            boolean result = false;

            computerPick(computerList);

            while (!result) {
                List<Integer> userList = new ArrayList<>();
                String inputString = startUserInput();
                isNull(inputString);
                isValidSize(inputString);
                isValidNumber(inputString);
                isContainsZero(inputString);
                isOverLap(inputString);
                makeUserList(inputString, userList);
                result = compareList(computerList, userList);
            }
            status = restartUserInput();
            continueGame(status);
        }
    }

    // 컴퓨터가 숫자를 선택하는 메서드
    static void computerPick(List<Integer> computerList) {
        while (computerList.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(pickNumber)) {
                computerList.add(pickNumber);
            }
        }
    }

    // 게임을 시작하고 사용자의 입력을 받는 메서드
    static String startUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return Console.readLine();
    }

    // 게임이 종료되고 사용자의 재시작 입력을 받는 메서드
    static String restartUserInput() {
        return Console.readLine();
    }

    // 사용자가 입력한 숫자로 리스트를 만드는 메서드
    static void makeUserList(String inputString, List<Integer> userList) {
        String[] array = inputString.split("");
        for (int i = 0; i < array.length; i++) {
            userList.add(Integer.parseInt(array[i]));
        }
    }

    // 사용자가 빈칸을 입력했을 때 예외 처리하는 메서드
    static void isNull(String inputString) {
        if (inputString.equals("")) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
    }

    // 사용자가 3글자가 아닌 숫자를 입력했을 때 예외 처리하는 메서드
    static void isValidSize(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해 주세요");
        }
    }

    // 사용자가 숫자가 아닌 문자열을 입력했을 때 예외 처리하는 메서드
    static void isValidNumber(String inputString) {
        ParsePosition parsePosition = new ParsePosition(0);
        NumberFormat.getInstance().parse(inputString, parsePosition);

        if (inputString.length() != parsePosition.getIndex()) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }

    // 사용자가 0이 포함된 숫자를 입력했을 때 예외 처리하는 메서드
    static void isContainsZero(String inputString) {
        if (inputString.contains("0")) {
            throw new IllegalArgumentException("1부터 9 사이 숫자만 입력해 주세요");
        }
    }

    // 사용자가 중복된 숫자를 입력했을 때 예외 처리하는 메서드
    static void isOverLap(String inputString) {
        Set<Integer> set = new HashSet<>();
        String[] array = inputString.split("");

        for (int i = 0; i < array.length; i++) {
            set.add(Integer.parseInt(array[i]));
        }

        if (set.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해 주세요");
        }
    }

    // 게임이 종료되고 사용자가 1이나 2을 입력하지 않았을 때 예외 처리하는 메서드
    static void continueGame(String inputString) {
        if (!(inputString.equals("1") || inputString.equals("2"))) {
            throw new IllegalArgumentException("1이나 2를 입력해 주세요");
        }
    }

    // 컴퓨터의 숫자와 사용자의 숫자를 비교하여 볼, 스트라이크를 세는 메서드
    static boolean compareList(List<Integer> computerList, List<Integer> userList) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < userList.size(); i++) {
            int result = compareNumber(computerList, userList.get(i), i);
            if (result == 1) {
                strike++;
            } else if (result == 0) {
                ball++;
            }
        }

        return output(ball, strike);
    }

    // 컴퓨터의 숫자와 사용자의 숫자를 비교하는 메서드
    static int compareNumber(List<Integer> computerList, int num, int idx) {
        if (computerList.contains(num)) {
            if (computerList.get(idx) == num) {
                return 1;
            }
            return 0;
        }
        return 3;
    }

    // 결과를 출력하는 메서드
    static boolean output(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }
}
