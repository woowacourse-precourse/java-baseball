package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int RESTART_NUMBER = 1;
    private static final int STOP_NUMBER = 2;
    private static final String RESTART_COMMENT = "게임을 새로 시작하려면 "+ RESTART_NUMBER +", 종료하려면 "+ STOP_NUMBER +"를 입력하세요.";
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
        System.out.println(RESTART_COMMENT);
        int restartCommand = Integer.parseInt(Console.readLine());
        return restartCommand == RESTART_NUMBER;
    }
}
