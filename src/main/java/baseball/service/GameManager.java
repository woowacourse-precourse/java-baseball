package baseball.service;

import baseball.domain.BaseballDto;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.status.Comments;
import baseball.status.Constants;
import baseball.utils.ConsoleUtil;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private boolean gameContinue = true;
    private BaseballDto baseballDto;
    private User user;

    public void run() {
        ConsoleUtil.consoleOutputLine(Comments.GAME_INITIALIZE.getComment());

        while (gameContinue) {
            Computer computer = new Computer();
            phaseStart(computer);
            getRestartCondition();
        }
    }

    private void phaseStart(Computer computer) {
        user = new User();
        baseballDto = new BaseballDto();
        GameLogic gameLogic = new GameLogic(computer.getComputerNumbers(), baseballDto);

        while (!gameEnd()) {
            initializeVariables();
            getUserInput();

            gameLogic.getBallAndStrikeCount(user.getUserNumbers());

            getResultOutput();
        }
    }

    private boolean gameEnd() {
        return baseballDto.getStrike() == Constants.NUMBER_OF_DIGITS.getNumber();
    }

    private void initializeVariables() {
        user.initializeUserNumbers();
        baseballDto.initializeBaseBallDto();
    }

    private void getUserInput() {
        ConsoleUtil.consoleOutput(Comments.INPUT_NUMBER.getComment());
        user.processUserInput();
    }

    private void getResultOutput() {
        String output = ConsoleUtil.ballAndStrikeOutput(baseballDto);
        ConsoleUtil.consoleOutputLine(output);
    }

    private void getRestartCondition() {
        ConsoleUtil.consoleOutputLine(Comments.CHOOSE_RESTART.getComment());
        gameContinue = isGameContinue(Integer.parseInt(Console.readLine()));
    }

    public boolean isGameContinue(int userGameContinueInput) {
        if (userGameContinueInput == Constants.GAME_STOP.getNumber()) {
            return false;
        }
        if (userGameContinueInput == Constants.GAME_CONTINUE.getNumber()) {
            return true;
        }
        throw new IllegalArgumentException(Comments.EXCEPTION.getComment());
    }
}
