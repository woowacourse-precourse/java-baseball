package baseball.view;

import static baseball.view.BaseBallMessage.*;

public class BaseBallDisplay {

    public static void printWelcomeMessage() {
        System.out.println(WELCOME.getMessage());
    }

    public static void printAnswerInputMessage() {
        System.out.println(ANSWER_INPUT.getMessage());
    }

    public static void printResultMessage(Integer ball, Integer strike) {
        String result = calResultMessage(ball,strike);

        System.out.println(result);
    }

    private static String calResultMessage(Integer ball, Integer strike) {
        StringBuilder result = new StringBuilder();

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball > 0) {
            result.append(ball).append("볼 ");
        } if (strike > 0) {
            result.append(strike).append("스트라이크");
        }

        return result.toString();
    }

    public static void printGameEndMessage() {
        System.out.println(GAME_END.getMessage());
    }

    public static void printProgressEndMessage() {
        System.out.println(PROGRESS_END.getMessage());
    }

    public static void printReStartInputMessage() {
        System.out.println(RESTART_INPUT.getMessage());
    }
}
