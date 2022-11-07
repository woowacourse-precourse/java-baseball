package baseball;

import java.util.Arrays;
import static baseball.Const.START_MESSAGE;

public class BaseballGame {

    private UserInput userInput = new UserInput();
    private AnswerGenerator answerGenerator = new AnswerGenerator();
    private BaseballGameHint baseballGameHint = new BaseballGameHint();

    public void start() {
        System.out.println(START_MESSAGE);
        answerGenerator.generateAnswer();
        do{
            userInput.setNumberOfUser();
            baseballGameHint.getHint(userInput.getUserInput(), answerGenerator.getAnswer());
        }while(!baseballGameHint.isAnswer());

        String userChoice = userInput.inputRestartOrStop();
        if ("1".equals(userChoice)) {
            start();
        }
    }
}
