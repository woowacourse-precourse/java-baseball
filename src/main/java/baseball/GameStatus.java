package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameStatus {
    private PrintView printView;
    public GameStatus(){
        printView=new PrintView();
    }

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            boolean stop=progressGame();
            if(stop){
                printView.printEndGame();
                break;
            }
        }
    }
    public boolean progressGame() throws IllegalArgumentException{
        RandomNumberGenerator randomNumberGenerator=new RandomNumberGenerator();
        InputChecker inputChecker=new InputChecker();
        AnswerResultJudgement answerResultJudgement=new AnswerResultJudgement(randomNumberGenerator.getRandomNumber());
        while(true){
            printView.printInput();
            String userAnswer= Console.readLine();
            inputChecker.checkInput(userAnswer);
            System.out.println(answerResultJudgement.getResult(userAnswer));
            if(answerResultJudgement.getResult(userAnswer).equals("3스트라이크")){
                break;
            }
        }
        return printView.isExit();
    }

}
