package baseball;

import baseball.config.AppConfig;
import baseball.domain.Number;
import baseball.domain.Referee;
import baseball.view.Input;
import baseball.view.Output;

public class Game {
    private boolean exit = false;
    private AppConfig appConfig;
    private Referee referee;

    public void start() {
        appConfig = new AppConfig();
        referee = appConfig.referee();

        Input input = appConfig.input();
        Output.printStartMessage();
        while (!exit) {
            String inputNumber = input.suggestNumber();
            Number judgeNumber = referee.judge(inputNumber);

            Output output = new Output(judgeNumber);
            output.printOutput();
            if (judgeNumber.isCorrect()) {
                Output.printEndMessage();
                restart();
            }

        }
    }

    private void restart() {
        Input input = appConfig.input();
        String inputMessage = input.continueOrNot();

        if (referee.judgeRestart(inputMessage)) {
            referee.reset();
        }

        if (!referee.judgeRestart(inputMessage)) {
            exit = true;
        }

    }
}
