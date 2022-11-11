package baseball.Controller;

import baseball.service.*;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private static final int NOTHING = 0;
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    private static final int SUCCESS = 3;

    public void run() {
        OutputView.printStartMessage();
        while (true) {
            startNewGame();
            if(!isReStart()) {
                OutputView.printExitMessage();
                break;
            }
        }
    }

    private void startNewGame() {
        Rule rule = new Rule();
        Player player = new Player();
        Computer computer = new Computer();
        rule.generateRandomNumber(computer);
        process(rule, player, computer);
    }


    private void process(Rule rule, Player player, Computer computer) {
        while (true) {
            //입력메세지 출력
            OutputView.printInputMessage();
            //번호입력 및유효성 검증
            rule.getNumberByPlayer(player);
            //결과처리
            BallStatus result = rule.decideStrikeOrBall(player.getThreeNumber(), computer.getThreeNumber());
            //결과에 따른 메세지 출력
            if(checkResult(result)) {
                return;
            }
        }

    }

    private boolean isReStart() {
        OutputView.printReStartMessage();
        String input = InputView.read();
        if (Validation.isValidReStart(input)) {
            return Integer.parseInt(input) == RESTART;
        }
        return false;
    }

    private boolean checkResult(BallStatus result) {
        if(result.getStrike() == SUCCESS) {
            OutputView.printOnlyStrikeMessage(result.getStrike());
            OutputView.printSuccessMessage();
            return true;
        }

        if(result.getStrike() == NOTHING && result.getBall() == NOTHING) {
            OutputView.printNothingMessage();
            return false;
        }

        if(result.getStrike() > NOTHING && result.getBall() == NOTHING) {
            OutputView.printOnlyStrikeMessage(result.getStrike());
            return false;
        }

        if(result.getStrike() == NOTHING && result.getBall() > NOTHING) {
            OutputView.printOnlyBallMessage(result.getBall());
            return false;
        }

        OutputView.printHintMessage(result.getStrike(), result.getBall());
        return false;
    }
}
