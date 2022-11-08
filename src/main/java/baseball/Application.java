package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Constant.START_MESSAGE);
        BaseBallGame baseBallGame = new BaseBallGame();
        do {
            // TODO: 게임 시작
            baseBallGame.start();
        } while (isRestart());
    }

    private static boolean isRestart() {
        // TODO: 게임 재시작 여부 판단
        System.out.println(Constant.RESTART_COMMENT);
        int restartCommand = Integer.parseInt(Console.readLine());
        if (restartCommand != Constant.RESTART_NUMBER && restartCommand != Constant.STOP_NUMBER) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.COMMAND_NOT_FOUND.getMessage());   // 예외 처리
        }
        return restartCommand == Constant.RESTART_NUMBER;
    }
}
