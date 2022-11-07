package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int RESTART_NUMBER = 1;
    private static final int STOP_NUMBER = 2;
    private static final String RESTART_COMMENT = "게임을 새로 시작하려면 "+ RESTART_NUMBER +", 종료하려면 "+ STOP_NUMBER +"를 입력하세요.";
    public static void main(String[] args) {
        do {
            BaseBallGame.start();
        } while (isRestart());
    }

    // 게임 재시작 여부
    private static boolean isRestart() {
        System.out.println(RESTART_COMMENT);
        int restartCommand = Integer.parseInt(Console.readLine());
        if (restartCommand != RESTART_NUMBER && restartCommand != STOP_NUMBER) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.COMMAND_NOT_FOUND.getMessage());   // 입력받은 데이터가 Command와 일치하지 않는 경우
        }
        return restartCommand == RESTART_NUMBER;
    }
}
