package baseball.controller;

import baseball.dto.GameResultResponseDto;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    public static final int CRITERION_DEFAULT = 0;
    public static final int CRITERION_RESTART = 1;
    public static final int CRITERION_END = 2;

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        OutputView.printGameStart();
        recursiveRound();
    }

    private void recursiveRound() {
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumbers();

        GameResultResponseDto responseDto = playRound(numbers);
        int restart = checkRestart(responseDto);

        if (isGameEnd(restart)) {
            return;
        }
        recursiveRound();
    }

    private GameResultResponseDto playRound(List<Integer> numbers) {
        gameService.changePlayerBalls(numbers);
        GameResultResponseDto responseDto = gameService.playGame();
        OutputView.printGameResult(responseDto);
        return responseDto;
    }

    private int checkRestart(GameResultResponseDto responseDto) {
        int restart = CRITERION_DEFAULT;
        if (responseDto.isThreeStrike()) {
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
        return restart == CRITERION_RESTART;
    }

    private boolean isGameEnd(int restart) {
        return restart == CRITERION_END;
    }
}
