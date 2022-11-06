package baseball;

import baseball.numbers.ComputerNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ComputerNumbers computerNumbers = new ComputerNumbers(Randoms.pickNumberInRange(1, 9),
                Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9));

        System.out.println(
                computerNumbers.getFirst() + " " + computerNumbers.getSecond() + " " + computerNumbers.getThird());
        System.out.println(userInput());
    }

    static String userInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력해 주세요 : ");
        String inputString;

        try {
            inputString = br.readLine();
        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }

        isValidInput(inputString);
        isValidSize(inputString);
        isContainsZero(inputString);
        isOverLap(inputString);

        return inputString;
    }

    static void isValidInput(String inputString) {
        ParsePosition parsePosition = new ParsePosition(0);
        NumberFormat.getInstance().parse(inputString, parsePosition);

        if (inputString.length() != parsePosition.getIndex()) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }

    static void isValidSize(String inputString) {
        if (inputString.length() == 0) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해 주세요");
        }
    }

    static void isContainsZero(String inputString) {
        if (inputString.contains("0")) {
            throw new IllegalArgumentException("1부터 9 사이 숫자만 입력해 주세요");
        }
    }

    static void isOverLap(String inputString) {
        Set<Integer> set = new HashSet<>();
        String[] arr = inputString.split("");

        for (int i = 0; i < arr.length; i++) {
            set.add(Integer.parseInt(arr[i]));
        }

        if (set.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해 주세요");
        }
    }

    static boolean continueGame(String inputString) {
        if(inputString.equals("1")) {
            return true;
        } else if (inputString.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1이나 2를 입력해 주세요");
        }
    }
}
