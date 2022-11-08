package baseball.message;

public interface ErrorMessage {
    // 유저의 숫자야구 추측 입력시
    String NUMERIC_INPUT_EXCEPTION = "1 ~ 9 사이의 숫자만 입력해야 합니다.";
    String NUMERIC_LENGTH_EXCEPTION = "3글자의 숫자를 입력해야 합니다.";
    String SAME_NUMBER_EXCEPTION = "3개의 숫자는 모두 달라야 합니다.";

    // 유저의 새게임 여부 입력시
    String NEW_GAME_INPUT_EXCEPTION = "1 또는 2만 입력해야 합니다.";

}
