package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    private static boolean canRestart(String usersInput) {
        if (usersInput.equals("1")) {
            return true;
        } else if (usersInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 인자를 입력 받았습니다.");
        }
    }
}
