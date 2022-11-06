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

        List<Integer> computerList = new ArrayList<>();
        computerPick(computerList);

        String inputString = startUserInput();
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
    static boolean continueGame(String inputString) {
        if (inputString.equals("1")) {
            return true;
        } else if (inputString.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1이나 2를 입력해 주세요");
        }
    }

}
