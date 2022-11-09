package baseball;

import baseball.domain.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restartFlag = true;
        while (restartFlag) {
            BaseballGame game = new BaseballGame();
            game.getNewGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exitCode = Console.readLine();
            isExitCodeValid(exitCode);
            if (exitCode.equals("2")) {
                restartFlag = false;
            }
        }
    }

    static void isExitCodeValid(String exitCode) {
        if (!(exitCode.equals("1") || exitCode.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}