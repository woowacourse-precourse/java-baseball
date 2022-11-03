package baseball.game;

import baseball.constant.GameConstant;
import baseball.constant.WarningMessage;
import baseball.data.AnswerNumber;
import baseball.data.UserNumber;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static void start() {
        boolean isContinued = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(isContinued) {
            Game.playGame();
            isContinued = isGameContinued();
        }
    }

    public static void playGame() {
        AnswerNumber answerNumber = AnswerNumber.getInstance();
        UserNumber userNumber = UserNumber.getInstance();
        boolean isAnswered = false;

        answerNumber.updateNumbers(Generator.generateAnswer());

        while(!isAnswered) {
            userNumber.updateNumbers(Scanner.getUserInput());

            Comparator comparator = Comparator.getInstance().compare(answerNumber.getNumbers(), userNumber.getNumbers());

            if(comparator.getStrike() == GameConstant.DIGIT.getValue()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isAnswered = true;
                break;
            }

            printResult(comparator);
        }
    }

    public static void printResult(Comparator comparator) {
        String result = new String();

        if(comparator.getBall() > 0) {
            result += comparator.getBall() + "볼 ";
        }

        if(comparator.getStrike() > 0) {
            result += comparator.getStrike() + "스트라이크";
        }

        if(result.isBlank()) {
            result += "낫싱";
        }

        System.out.println(result);
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
