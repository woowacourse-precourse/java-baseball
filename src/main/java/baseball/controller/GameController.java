package baseball.controller;

import baseball.dto.GameResultResponseDto;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    public static final int CRITERION_GAME_CONTINUE = 0;
    public static final int CRITERION_GAME_RESTART = 1;
    public static final int CRITERION_GAME_OVER = 2;

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        OutputView.printGameStart();
        recursiveGame();
    }

    private void recursiveGame() {
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumbers();

        GameResultResponseDto responseDto = playGame(numbers);
        int restart = checkRestart(responseDto);

        if (isGameOver(restart)) {
            return;
        }
        recursiveGame();
    }

    private GameResultResponseDto playGame(List<Integer> numbers) {
        GameResultResponseDto responseDto = gameService.playGame(numbers);
        OutputView.printGameResult(responseDto);
        return responseDto;
    }

    private int checkRestart(GameResultResponseDto responseDto) {
        int restart = CRITERION_GAME_CONTINUE;
        if (responseDto.isGameEnd()) {
            OutputView.printGameEnd();
            OutputView.printGameRestart();
            restart = InputView.inputRestart();
        }
        if (isGameRestart(restart)) {
            gameService.changeComputerBalls();
        }
        return restart;
    }

    private boolean isGameRestart(int restart) {
        return restart == CRITERION_GAME_RESTART;
    }

    private boolean isGameOver(int restart) {
        return restart == CRITERION_GAME_OVER;
    }

}
