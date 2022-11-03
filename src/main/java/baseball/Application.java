package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return readLine();
    }
    static void checkInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        boolean[] used = new boolean[10];
        used[0] = true;
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || used[ch - '0']) {
                throw new IllegalArgumentException();
            }
            used[ch - '0'] = true;
        }
    }

    public static void main(String[] args) {
        printGameStart();
    }
}
