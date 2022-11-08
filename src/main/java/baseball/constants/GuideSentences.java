package baseball.constants;

public enum GuideSentences {
    START_GUIDE("숫자 야구 게임을 시작합니다."),
    INPUT_GUIDE("숫자를 입력해주세요 : "),
    END_GUIDE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_GUIDE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String sentence;

    GuideSentences(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }
}
