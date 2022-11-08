package baseball;

public enum GameProgressLine {
    START_LINE("숫자 야구 게임을 시작합니다."),
    PLAYER_INPUT_LINE("숫자를 입력해주세요 : "),
    END_LINE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_RETRY_LINE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    final private String line;

    GameProgressLine(String line){
        this.line = line;
    }
}
