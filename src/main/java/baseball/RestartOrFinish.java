package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartOrFinish {

    private void finishOrRestart(int selectFinishOrRestart) {
        if (selectFinishOrRestart == 1) {
            reStart();
        } else if (selectFinishOrRestart == 2) {
            System.out.println("게임 종료");
        } else {
            finishGameExceptionHandling(selectFinishOrRestart);
        }
    }

    private void reStart() {
        Game restart = new Game();
        restart.start();
    }

    public void finishGameExceptionHandling(int selectFinishOrRestart) {
        if (selectFinishOrRestart != 2 && selectFinishOrRestart != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void finishGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int selectFinishOrRestart = Integer.parseInt(Console.readLine());
        finishOrRestart(selectFinishOrRestart);
    }
}
