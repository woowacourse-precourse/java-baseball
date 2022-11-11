package baseball.controller;

import baseball.domain.*;
import baseball.view.OutputView;


public class GameController {

    private final Game game;
    private Player player;
    private Computer computer;

    public GameController(Game game, Computer computer) {
        this.game = game;
        this.computer = computer;
    }

    public void run() {
        initGame();
        do {
            playGame();
            String command = checkRestartWhenMaxStrike();
            setActionOfRestartAndExit(command);
        } while (!game.isExitStatus());
    }

    public void initGame() {
        OutputView.printInit();
    }

    public void playGame() {
        OutputView.printInput();
        player = Player.create();
        playBaseBall();
        OutputView.printGameResult(game);
    }

    private void playBaseBall() {
        int strikeCount = Referee.getStrikeCount(player.getBalls(), computer.getBalls());
        int ballCount = Referee.getBallCount(player.getBalls(), computer.getBalls());
        game.setGameResult(strikeCount, ballCount);
    }

    public String checkRestartWhenMaxStrike() {
        if (!game.isMaxStrike()) {
           return GameStatus.PROGRESS.number();
        }

        OutputView.printFinishAndRestart();
        return player.getRestartResponse();
    }

    public void setActionOfRestartAndExit(String command) {
        isRestartGenerateNewComputer(command);
        isExitSetGameStatus(command);
        game.clearResult();
    }

    private void isRestartGenerateNewComputer(String command) {
        if (GameStatus.isRestart(command)) {
            computer = Computer.createComputer();
        }
    }

    private void isExitSetGameStatus(String command) {
        if (GameStatus.isExit(command)) {
            game.setExitStatus();
        }
    }
}
