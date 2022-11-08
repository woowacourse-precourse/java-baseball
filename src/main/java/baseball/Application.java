package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        if (gamePlaying() != 2) {
            gamePlaying();
        }
    }

    public static List<Integer> pickGameNumber() {
        List<Integer> gameNumberList = new ArrayList<>();
        while (gameNumberList.size() != 3) {
            checkNumber(gameNumberList);
        }
        return gameNumberList;
    }

    public static void checkNumber(List<Integer> numberList) {
        int num = Randoms.pickNumberInRange(1, 9);
        if (!numberList.contains(num)) {
            numberList.add(num);
        }
    }

    public static List<Integer> inputGameNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumberList;
        String inputNum = readLine();
        userNumberList = checkInput_userNumber(inputNum);
        return userNumberList;
    }

    public static List<Integer> checkInput_userNumber(String str) {
        List<Integer> userNumberList;
        checkFormat(str);
        checkSize(str);
        userNumberList = checkNotEqual(str);
        return userNumberList;
    }

    public static void checkFormat(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static void checkSize(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    public static List<Integer> checkNotEqual(String str) {
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int userNumber = Character.getNumericValue(str.charAt(i));
            if (userNumberList.contains(userNumber)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
            }
            userNumberList.add(userNumber);
        }
        return userNumberList;
    }

    public static int checkGameCode(String str) {
        try {
            if (Integer.parseInt(str) != 1 && Integer.parseInt(str) != 2) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(str);
    }

    public static int gamePlaying() {
        List<Integer> gameNumberList = pickGameNumber();

        int strike = 0;
        int ball;

        while (strike != 3) {
            List<Integer> userNumberList = inputGameNumber();
            strike = 0;
            ball = 0;
            ResultData resultData = new ResultData(gameNumberList, userNumberList, strike, ball);
            strike = resultData.getStrike();
            resultData.printResult();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameCode = readLine();
        return checkGameCode(gameCode);
    }
}
