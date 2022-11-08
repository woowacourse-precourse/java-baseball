package baseball;

import baseball.domain.BaseballGameMachine;
import baseball.domain.Baseballs;
import baseball.domain.GameResult;
import baseball.domain.GameState;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        runGame(inputView);
        scanner.close();
    }

    public static void runGame(InputView inputView) {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(Baseballs.generateRandomBaseballNumbers());
        GameState gameState = GameState.init();
        while (gameState.isPlayable()) {
            baseballGameMachine = baseballGameMachine.play(gameState);
            Baseballs userBaseballs = Baseballs.generateInputBaseballNumbers(inputView.getBaseballNumbers());
            GameResult gameResult = baseballGameMachine.judgeGameResult(userBaseballs);
            OutputView.writeGameResult(gameResult);
            gameState = GameState.findGameState(inputView.getGameState(gameResult));
        }
    }
}
