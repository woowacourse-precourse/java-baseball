package baseball;

import java.util.List;

import static baseball.Hint.S3;

public class Game {
    public static int GAME_LENGTH = 3;

    private final int GAME_RESTART_VALUE = 1;
    private final int GAME_END_VALUE = 2;

    private Referee referee;
    private Catcher catcher;
    private Pitcher pitcher;
    private List<Integer> catcherNumbers;
    private boolean flagGameProcess = true;

    public Game(Referee referee, Catcher catcher, Pitcher pitcher) {
        this.referee = referee;
        this.catcher = catcher;
        this.pitcher = pitcher;
    }

    public void start() {
        notifyGameStart();
        catcherNumbers = catcher.generateRandomNumbers();
        while (flagGameProcess) {
            notifyPitchBall();
            List<Integer> pitcherNumbers = pitcher.pitch();
            Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
            notifyHint(hint);
            if (hint == S3) {
                notifyGameEnd();
                notifyGameRestart();
                gameRestartOrEnd(pitcher.selectGameRestartOrEnd());
            }
        }
    }

    private void notifyGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void notifyPitchBall() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void notifyGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void notifyGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void notifyHint(Hint hint) {
        System.out.println(hint.getLabel());
    }

    private void gameRestartOrEnd(int selectionForRestartOrEnd) {
        if (selectionForRestartOrEnd == GAME_RESTART_VALUE) {
            restartGame();
        }
        if (selectionForRestartOrEnd == GAME_END_VALUE) {
            endGame();
        }
    }

    private void restartGame() {
        catcherNumbers = catcher.generateRandomNumbers();
    }

    private void endGame() {
        flagGameProcess = false;
    }
}
