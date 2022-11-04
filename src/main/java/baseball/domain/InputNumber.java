package baseball.domain;

import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumber {
    public String getNumbers() {
        Scanner scanner = new Scanner(readLine());
        String number = scanner.next();
        System.out.println("숫자를 입력해주세요 : " + number);
        return number;
    }

    public static String restartNum() {
        Scanner scanner = new Scanner(readLine());
        String number = scanner.next();
        return number;
    }
}
