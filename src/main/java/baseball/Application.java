package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int RESTART_NUMBER = 1;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: 출력 Comment 추가
        do {
            // TODO: 게임 시작
            BaseBallGame.start();
        } while (isRestart());
    }

    // TODO: 게임 재시작 여부
    private static boolean isRestart() {
        int restartCommand = Integer.parseInt(Console.readLine());
        return restartCommand == RESTART_NUMBER;
    }
}
