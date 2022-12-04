package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Baseball;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.util.GameStatus;
import baseball.util.OutputPharse;
import baseball.util.PlayStatus;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballGame baseballGame;

    public BaseballController(InputView inputView, OutputView outputView, BaseballGame baseballGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballGame = baseballGame;
    }

    public void initController() {
        outputView.printMsgWithLn(OutputPharse.GAME_START.getMsg());
    }

    public void play() {
        boolean isContinue = true;
        while (isContinue) {
            playEachGame();
            isContinue = getUserRetry();
            if (isContinue) {
                retry();
            }
        }
    }

    public void retry() {
        baseballGame.retry();
    }

    public void playEachGame() {
        while (!baseballGame.isGameFinish()) {
            baseballGame.setPlayerNumber(getBaseballNumber());
            baseballGame.play();
            outputView.printMsgWithLn(getHintCode(baseballGame.getResult()));
        }
    }

    public String getHintCode(Result result) {
        return getHint(result.getBallCount(), result.getStrickCount());
    }

    public String getHint(int ballCount, int strikeCount) {
        if ((ballCount + strikeCount) == 0) {
            return OutputPharse.NOTHING.getMsg();
        }
        return makeHint(ballCount, strikeCount);
    }

    public String makeHint(int ballCount, int strikeCount) {
        StringBuilder hintCode = new StringBuilder();
        if (ballCount != 0) {
            hintCode.append(ballCount+OutputPharse.BALL.getMsg());
        }
        if (strikeCount != 0) {
            hintCode.append(OutputPharse.SPACE_BAR.getMsg()+strikeCount+OutputPharse.STRICK.getMsg());
        }
        return hintCode.toString().strip();
    }

    public String getBaseballNumber() {
        outputView.printMsg(OutputPharse.INPUT_INFO.getMsg());
        return inputView.getUserNumber();
    }

    public boolean getUserRetry() {
        outputView.printMsgWithLn(OutputPharse.GAME_END.getMsg());
        return doNewGame(inputView.getGameNumber());
    }

    public boolean doNewGame(int userInput) {
        return PlayStatus.NEW_GAME.getPlayStatus() == userInput;
    }
}
