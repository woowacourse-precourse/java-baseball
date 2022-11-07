package baseball;

import baseball.controller.ExitFlagController;
import baseball.controller.InfoPrinter;
import baseball.controller.NumberController;
import baseball.vo.AnswerNumber;
import baseball.vo.UserNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    static final int FINISH_FLAG = 2;
    public static void main(String[] args) {
        int flag = 0;

        while (flag != FINISH_FLAG) {
        InfoPrinter.printStartInfo();
        AnswerNumber answerNumber = new AnswerNumber();
        int strikes = 0;
            while (strikes < AnswerNumber.MAX_NUMBER_OF_DIGIT) {
                InfoPrinter.printInputInfo();
                UserNumber userNumber = new UserNumber(Console.readLine());
                List<Integer> strikesAndBalls = NumberController.getStrikesAndBalls(userNumber, answerNumber);
                InfoPrinter.printStrikesAndBalls(strikesAndBalls);
                strikes = strikesAndBalls.get(0);
            }
        InfoPrinter.printExitInfo();
        flag = ExitFlagController.getExitFlag();
        }
        System.out.println("게임 종료");
    }
}
