package baseball;

import baseball.exception.ExceptionMessage;
import baseball.gametype.BaseballType;
import baseball.message.InputRequestMessage;
import baseball.message.OutputMessage;
import baseball.question.BaseballQuestion;
import basedomain.input.Input;
import basedomain.output.Output;

public class BaseballApplication {

    private Input input;
    private Output output;

    private final int RESTART_APPLICATION = 1;
    private final int FINISH_APPLICATION = 2;

    BaseballApplication(Input input, Output output){
        this.input = input;
        this.output = output;
    }

    public void run(BaseballType BaseballType) {
        output.print(OutputMessage.START_MESSAGE);

        boolean isStart = true;
        while (isStart) {
            startGame(BaseballType);
            isStart = askRestartApplication();
        }
    }

    private void startGame(BaseballType baseballType) {
        BaseballQuestion question = new BaseballQuestion(baseballType);

        boolean isCorrect = false;
        while (!isCorrect) {
            output.print(InputRequestMessage.ASK_INPUT_INTEGER);
            int inputData = input.getInputInteger();

            String result = question.ask(inputData);
            output.println(result);
            isCorrect = question.isCorrect(inputData);
        }
        output.print(OutputMessage.CORRECT_MESSAGE);
    }

    private boolean askRestartApplication() {
        output.print(InputRequestMessage.ASK_APPLICATION_RESTART);
        int inputData = input.getInputInteger();
        return judgeRestartApplication(inputData);
    }

    private boolean judgeRestartApplication(int inputData) {
        if (inputData == RESTART_APPLICATION) {
            return true;
        }
        if (inputData == FINISH_APPLICATION) {
            return false;
        }
        throw new IllegalArgumentException(ExceptionMessage.NOT_RESTART_FORMAT.toString());
    }
}
