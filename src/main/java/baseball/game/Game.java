package baseball.game;

import baseball.constant.GameConstant;
import baseball.constant.WarningMessage;
import baseball.data.AnswerNumber;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static void playGame() {
        AnswerNumber answerNumber = AnswerNumber.getInstance();

        answerNumber.updateNumbers(Generator.generateAnswer());
    }

    public static boolean isGameContinued() {
        int input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        input = Integer.parseInt(Console.readLine());

        if (input == GameConstant.START.getValue()) {
            return true;
        }

        if (input == GameConstant.END.getValue()) {
            return false;
        }

        throw new IllegalArgumentException(WarningMessage.IllegalInputWarningMessage.getMessage());
    }
}
