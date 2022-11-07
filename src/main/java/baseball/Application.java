package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initGame();
    }

    /**
     * 게임 진행을 담당하는 함수
     */
    public void initGame() {
        GameStatus status = GameStatus.CONTINUE;
        do {
            if (isStopStatus(status)) {
                break;
            }
            if (isExceptionStatus(status)) {
                throw new IllegalArgumentException();
            }

            GameFormatter.gameStartMessage();
            GameFormatter.gameInputMessage();
            GameFormatter.gameEndMessage();
            status = setGameStatus(Console.readLine());
        } while (true);
    }

    /**
     * 게임 진행 상황을 제어하는 함수
     *
     * @param input
     * @return GameStatus
     */
    GameStatus setGameStatus(String input) {
        GameStatus status;
        switch (input) {
            case "1":
                status = GameStatus.CONTINUE;
                break;
            case "2":
                status = GameStatus.STOP;
                break;
            default:
                status = GameStatus.EXCEPTION;
                break;
        }
        return status;
    }

    boolean isStopStatus(GameStatus status) {
        return status.equals(GameStatus.STOP);
    }

    boolean isExceptionStatus(GameStatus status) {
        return status.equals(GameStatus.EXCEPTION);
    }


}
