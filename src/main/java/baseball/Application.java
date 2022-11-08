package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        do {
            // TODO: 게임 시작
            baseBallGame.start();
        } while (isRestart());
    }

    private static boolean isRestart() {
        // TODO: 게임 재시작 여부 판단
        int restartCommand = Integer.parseInt(Console.readLine());
        return restartCommand == Constant.RESTART_NUMBER;
    }
}
