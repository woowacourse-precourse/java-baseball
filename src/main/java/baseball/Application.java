package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        RandomNumberGenerator randomNumberGenerator=new RandomNumberGenerator();
        InputChecker inputChecker=new InputChecker();
        AnswerResultJudgement answerResultJudgement=new AnswerResultJudgement(randomNumberGenerator.getRandomNumber());
        MenuPrinter menuPrinter=new MenuPrinter();

        boolean correct=false;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!correct) {
            menuPrinter.printMenu(correct);
            String input = Console.readLine();
            inputChecker.checkInput(input);
            System.out.println(answerResultJudgement.getResult(input));
            if(answerResultJudgement.getResult(input).equals("3스트라이크")){
                correct=true;
                menuPrinter.printMenu(correct);
                break;
            }
        }
    }
}
