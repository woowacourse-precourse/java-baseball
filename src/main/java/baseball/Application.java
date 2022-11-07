package baseball;

import baseball.controller.InfoPrinter;
import baseball.controller.NumberController;
import baseball.vo.AnswerNumber;
import baseball.dto.ExitFlag;
import baseball.vo.UserNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ExitFlag exitFlag = new ExitFlag();

        while (exitFlag.getExitFlag() != ExitFlag.FINISH_FLAG) {
        int strikes = 0;
        AnswerNumber answerNumber = new AnswerNumber();

        InfoPrinter.printStartInfo();
            while (strikes < AnswerNumber.MAX_NUMBER_OF_DIGIT) {
                InfoPrinter.printInputInfo();
                UserNumber userNumber = new UserNumber(Console.readLine());
                List<Integer> strikesAndBalls = NumberController.getStrikesAndBalls(userNumber.getNumbers(),
                        answerNumber.getNumbers());

                InfoPrinter.printStrikesAndBalls(strikesAndBalls);
                strikes = strikesAndBalls.get(0);
            }
        InfoPrinter.printExitInfo();
        exitFlag.setExitFlag(Console.readLine());
        }
        InfoPrinter.printFinishInfo();
    }
}
