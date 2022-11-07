package baseball;

import baseball.game.CalcGame;
import baseball.game.EndGame;
import baseball.game.StrikeNumberGenerator;
import baseball.object.GameResult;
import baseball.object.GameStatus;
import baseball.view.GameView;

public class Application {
    private static GameStatus status;

    public static void main(String[] args) {
        baseball();
    }

    private static void baseball() {

        GameView.printStartView();
        status = GameStatus.RESTART;

        while (status == GameStatus.RESTART) {
            playGame();

            GameView.printGameRestart();
            Integer input = getNumber(GameView.getInputNumber());

            if (!EndGame.isRestart(input)) {
                status = GameStatus.END;
            }
        }

    }

    private static void playGame() {

        Boolean isPlay = true;
        CalcGame.setStrikeNumber(StrikeNumberGenerator.getStrikeNumber());

        while (isPlay) {
            GameView.printInputView();
            Integer input = getNumber(GameView.getInputNumber());
            System.out.println(input);
            GameResult result = CalcGame.calcGameResult(input);
            GameView.printGameResult(result);

            if (result.isGameEnd()) {
                GameView.printGameEnd();
                isPlay = false;
            }
        }
    }

    private static Integer getNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }
}
