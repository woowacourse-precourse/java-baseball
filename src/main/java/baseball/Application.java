package baseball;

import baseball.controller.InfoPrinter;
import baseball.controller.InputController;
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
            while (true) {
                InfoPrinter.printInputInfo();
                UserNumber userNumber = new UserNumber(Console.readLine());
                List<Integer> strikesAndBalls = NumberController.getStrikesAndBalls(userNumber.getNumbers(),
                        answerNumber.getNumbers());

                InfoPrinter.printStrikesAndBalls(strikesAndBalls);

                if (strikesAndBalls.get(0) == 3) {
                    break;
                }
            }
        InfoPrinter.printExitInfo();
        flag = InputController.getExitFlag();
        }
        System.out.println("게임 종료");
    }
}
