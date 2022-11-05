package baseball;

public enum GameMassage {
    START_MASSAGE("숫자 야구 게임을 시작합니다.\n"),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    NOT_ANSWER("%d볼 %d스트라이크\n"),
    NOTHING("낫싱\n"),
    THREE_STRIKE("3스트라이크\n"),
    ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private String massage;

    GameMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
