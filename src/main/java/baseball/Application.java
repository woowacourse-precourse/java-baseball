package baseball;

import baseball.numbers.ComputerNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class Application {
    public static void main(String[] args) {
        ComputerNumbers computerNumbers = new ComputerNumbers(Randoms.pickNumberInRange(1, 9),
                Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9));
        System.out.println(userInput());
    }

    static String userInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해 주세요 : ");
        boolean flag;
        String inputString;

        try {
            inputString = br.readLine();
            flag = isValid(inputString);
        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }

        if (flag) {
            return inputString;
        } else {
            throw new IllegalArgumentException();
        }

    }

    static boolean isValid(String inputString) {
        ParsePosition parsePosition = new ParsePosition(0);
        NumberFormat.getInstance().parse(inputString, parsePosition);

        return (inputString.length() == 3) && (inputString.length() == parsePosition.getIndex());
    }
}
