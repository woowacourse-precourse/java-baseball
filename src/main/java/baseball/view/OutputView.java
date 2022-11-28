package baseball.view;

import baseball.domain.Result;

public final class OutputView {
    public enum Message {
        REQUEST_NUMBER("숫자를 입력해주세요 : "),
        REQUEST_RESTART_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.%n"),
        START_GAME("숫자 야구 게임을 시작합니다.%n"),
        GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료%n");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    private OutputView() {

    }

    public static void printMessage(Message message) {
        System.out.printf(message.toString());
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }

    public static void printGameStatus(Result result) {
        System.out.println(result.makeMessage());
    }
}
