package baseball.view;

import baseball.model.GameResult;

public class OutputView {
    public final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public final static String INPUT_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String NOTHING_MESSAGE = "낫싱";
    public final static String STRIKE_MESSAGE = "스트라이크";
    public final static String BALL_MESSAGE = "볼";

    private void printlnMessage(String message) {

        System.out.println(message);
    }

    private void printMessage(String message) {

        System.out.print(message);
    }

    public void printStart() {

        printlnMessage(START_MESSAGE);
    }

    public void printEnd() {

        printlnMessage(END_MESSAGE);
    }

    public void printInputRetry() {

        printlnMessage(INPUT_RETRY_MESSAGE);
    }

    public void printInputNumber() {

        printMessage(INPUT_NUMBER_MESSAGE);
    }

    public String getBallMessage(int ball) {
        String ballMessage = "";
        if (ball != 0) {
            ballMessage += ball + BALL_MESSAGE;
        }
        return ballMessage;
    }

    public String getStrikeMessage(int strike) {
        String strikeMessage = "";
        if (strike != 0) {
            strikeMessage += strike + STRIKE_MESSAGE;
        }
        return strikeMessage;
    }

    public void printResult(GameResult gameResult) {

        printResult(gameResult.getBall(), gameResult.getStrike());
    }

    public void printResult(int ball, int strike) {
        String resultMessage = "";
        String ballMessage = getBallMessage(ball);
        String strikeMessage = getStrikeMessage(strike);

        resultMessage += ballMessage;
        if (ball != 0 && strike != 0) {
            resultMessage += " ";
        }
        resultMessage += strikeMessage;
        if (resultMessage.equals("")) {
            resultMessage = NOTHING_MESSAGE;
        }
        printlnMessage(resultMessage);
    }
}
