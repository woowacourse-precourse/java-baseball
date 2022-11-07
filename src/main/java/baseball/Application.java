package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        RandomNumberGenerator randomNumberGenerator=new RandomNumberGenerator();
        InputChecker inputChecker=new InputChecker();
        AnswerResultJudgement answerResultJudgement=new AnswerResultJudgement(randomNumberGenerator.getRandomNumber());
        String answer=Console.readLine();
        inputChecker.checkInput(answer);
        System.out.println(answerResultJudgement.getResult(answer));
    }
}
