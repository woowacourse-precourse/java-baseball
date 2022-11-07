package baseball.controller;

import static baseball.Constants.INTRO_TEXT;
import static baseball.Constants.START;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.domain.Player;
import baseball.service.ComputerService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private ComputerService computerService;

    public GameController(ComputerService computerService) {
        this.computerService = computerService;
    }

    public void run() {
        gameStart();
    }

    public void roundStart() {
        Computer computer = computerService.createAnswer();

        int state = START;
        while (state == START) {

            Player player = new Player(InputView.roundInput());

            Referee referee = new Referee(computer, player);
            Result result = referee.judge();

            String roundOutput = OutputView.roundOutput(result);
            System.out.println(roundOutput);

            state = result.isRoundFinish();
        }
    }

    public void gameStart() {
        System.out.println(INTRO_TEXT);

        int state = START;

        while (state == START) {
            roundStart();

            state = InputView.restartOrExitInput();
        }
    }
}
