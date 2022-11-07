package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getNumber() {
        String inputString =  Console.readLine();
        int inputNumber;

        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (inputString.length() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해주세요.");
        }

        if (inputString.charAt(0) == inputString.charAt(1)
                || inputString.charAt(0) == inputString.charAt(2)
                || inputString.charAt(1) == inputString.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 숫자 3자리를 입력해주세요.");
        }

        return inputNumber;
    }

    public static int isReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String inputString = Console.readLine();

        if (!(inputString.equals("1") || inputString.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        return Integer.parseInt(inputString);
    }
}
