package baseball;

import java.util.List;

import static baseball.Const.START_MESSAGE;

public class BaseballGame {

    private UserInput userInput;
    private AnswerGenerator answerGenerator;
    private BaseballGameHint baseballGameHint;

    public BaseballGame(){
        userInput = new UserInput();
        answerGenerator = new AnswerGenerator();
        baseballGameHint = new BaseballGameHint();
    }

    public void start() {
        System.out.println(START_MESSAGE);

        List<Integer> answer= answerGenerator.generateAnswer();
        do{
            baseballGameHint.getHint(userInput.setNumberOfUser(),answer);

        }while(!baseballGameHint.isAnswer());

        String userChoice = userInput.inputRestartOrStop();
        if ("1".equals(userChoice)) {
            start();
        }
    }
}
