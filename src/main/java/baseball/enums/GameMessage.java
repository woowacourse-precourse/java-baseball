package baseball.enums;

public enum GameMessage {

   INPUT_NUMBER("숫자를 입력해주세요 : "),
   GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
   GAME_START("숫자 야구 게임을 시작합니다."),
   GAME_COMPLETE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String value() {
        return this.message;
    }
}
