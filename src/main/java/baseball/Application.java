package baseball;

import baseball.controller.InfoPrinter;
import baseball.bo.StrikesAndBalls;
import baseball.bo.AnswerNumber;
import baseball.bo.ExitFlag;
import baseball.bo.UserNumber;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        ExitFlag exitFlag = new ExitFlag();

        while (exitFlag.getExitFlag() != ExitFlag.FINISH_FLAG) {
            StrikesAndBalls strikesAndBalls = new StrikesAndBalls(0, 0);
            AnswerNumber answerNumber = new AnswerNumber();
            InfoPrinter.printStartInfo();
            while (strikesAndBalls.getStrikes() < AnswerNumber.MAX_NUMBER_OF_DIGIT) {
                InfoPrinter.printInputInfo();
                UserNumber userNumber = new UserNumber(Console.readLine());
                strikesAndBalls.calcStrikesAndBalls(userNumber.getNumbers(), answerNumber.getNumbers());
                InfoPrinter.printStrikesAndBalls(strikesAndBalls.getStrikesAndBalls());
            }
            InfoPrinter.printExitInfo();
            exitFlag.setExitFlag(Console.readLine());
        }
        InfoPrinter.printFinishInfo();
    }
}
