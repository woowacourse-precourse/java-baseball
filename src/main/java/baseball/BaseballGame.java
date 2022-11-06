package baseball;

import java.util.Arrays;

public class BaseballGame {

    private final String START_Message = "숫자 야구 게임을 시작합니다.";
    private final UserInput userInput = new UserInput();
    private final AnswerGenerator answerGenerator= new AnswerGenerator();
    private final BaseballGameHint baseballGameHint= new BaseballGameHint();

    public void start() {
        System.out.println(START_Message);
        answerGenerator.generateAnswer();
        do{
            System.out.println(Arrays.toString(answerGenerator.getAnswer()));
            userInput.setNumberOfUser();
            baseballGameHint.getHint(userInput.getUserInput(), answerGenerator.getAnswer());
        }while(!baseballGameHint.isAnswer());

        String userChoice = userInput.inputRestartOrStop();
        if ("1".equals(userChoice)) {
            start();
        }
    }
}
