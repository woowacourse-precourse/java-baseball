package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            String input = Console.readLine();
            if (isThreeNumber(input)) {

            } else {
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해야 합니다.");
            }
        }
    }

    public static boolean isThreeNumber(String input) {
        String pattern = "[1-9]{3}";
        if (input.matches(pattern)) {
            return true;
        }
        return false;
    }
}
