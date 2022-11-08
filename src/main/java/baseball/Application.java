package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String usersInput = "";

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            NumberBaseball.newGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            usersInput = Console.readLine();
        } while (canRestart(usersInput));
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
