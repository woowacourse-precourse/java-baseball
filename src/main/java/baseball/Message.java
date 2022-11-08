package baseball;

import java.util.HashMap;

public enum Message {
    START("숫자 야구 게임을 시작합니다.\n"),
    SELECT_BALLS("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(this.message);
    }

    public static void printGameResult(HashMap<Message, Integer> gameResults) {
        StringBuilder gameResultMessage = new StringBuilder();

        int ball = gameResults.get(Message.BALL);
        if (ball > 0) {
            gameResultMessage
                .append(ball)
                .append(Message.BALL.message)
                .append(' ');
        }

        int strike = gameResults.get(Message.STRIKE);
        if (strike > 0) {
            gameResultMessage
                .append(strike)
                .append(Message.STRIKE.message);
        }

        System.out.println(gameResultMessage);
    }
}
