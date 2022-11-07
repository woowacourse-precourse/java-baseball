package baseball;

class User {
    private enum Message {
        GREET("숫자 야구 게임을 시작합니다."),
        PROMPT_FOR_NUMBER("숫자를 입력해주세요 : "),
        CONGRATULATE(Play.getCount() + "개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        PLAY_ON("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String message;
        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }

    /**
     * Enforce class non-instantiability with private constructor.
     */
    private User() {
        throw new AssertionError();
    }
}
