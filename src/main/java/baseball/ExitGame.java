package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ExitGame {
    public boolean exitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exit = Console.readLine();
        if (exit.equals("1")) {
            return true;
        } else if (exit.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
