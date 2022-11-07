package baseball;

import java.util.List;

public class BaseballGame {

    private final RandomNumberGenerator randomNumberGenerator;
    private final UserInput userInput;
    private final BaseballGameHint baseballGameHint;
    private final ResultChecker resultChecker;

    public BaseballGame() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.userInput = new UserInput();
        this.baseballGameHint = new BaseballGameHint();
        this.resultChecker = new ResultChecker();
    }

    public void run(){
        do{
            play();
        }while(userInput.isContinue());
    }

    public void play(){
        String hint = "";
        List<Integer> computer = randomNumberGenerator.createNumber();

        do{
            List<Integer> player = userInput.inputNumber();
            hint = baseballGameHint.generateHint(computer, player);
            System.out.println(hint);
        }while(!resultChecker.checkRightAnswer(hint));
    }
}
