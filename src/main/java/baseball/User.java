package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static int INPUT_LENGTH = 3;

    static List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() > INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (int idx = 0; idx < INPUT_LENGTH; idx++) {
            if (input.charAt(idx) < '1' || input.charAt(idx) > '9') {
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요");
            }
        }
        List<Integer> inputNum = new ArrayList<>();
        for (int idx = 0; idx < INPUT_LENGTH; idx++) {
            inputNum.add(input.charAt(idx) - '0');
        }
        int num1 = inputNum.get(0);
        int num2 = inputNum.get(1);
        int num3 = inputNum.get(2);
        if (num1 == num2 || num2 == num3 || num1 == num3) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

    static int getExitOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputStatus = Console.readLine();
        if (!inputStatus.equals("1") && !inputStatus.equals("2")) {
            throw new IllegalArgumentException();
        }
        int inputStatusNumber = Integer.parseInt(inputStatus);
        return inputStatusNumber;
    }
}
