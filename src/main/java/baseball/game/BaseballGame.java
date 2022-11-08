package baseball.game;

import baseball.user.UserInput;

import java.util.List;

import static baseball.util.Const.START_MESSAGE;

public class BaseballGame {

    private UserInput userInput;
    private BaseballAnswerGenerator baseballAnswerGenerator;
    private BaseballGameHint baseballGameHint;

    public BaseballGame(){
        userInput = new UserInput();
        baseballAnswerGenerator = new BaseballAnswerGenerator();
        baseballGameHint = new BaseballGameHint();
    }

    public void start() {
        System.out.println(START_MESSAGE);

        List<Integer> answer= baseballAnswerGenerator.generateAnswer();
        do{
            baseballGameHint.getHint(userInput.setNumberOfUser(),answer);

        }while(!baseballGameHint.isAnswer());

        String userChoice = userInput.inputRestartOrStop();
        if ("1".equals(userChoice)) {
            start();
        }
    }
}
