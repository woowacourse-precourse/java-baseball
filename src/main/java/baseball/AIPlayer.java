package baseball;

public final class AIPlayer {

    private final BaseballGamePolicy baseballGamePolicy;

    public AIPlayer(String answer) {
        this.baseballGamePolicy = new BaseballGamePolicy(answer);
    }

    /**
     * 상대 플레이어의 추측에 대해 답을 반환
     */
    public String scoreOf(String guess) {
        return baseballGamePolicy.scoreOf(guess);
    }

    /**
     * 컴퓨터 플레이어의 패배 여부를 반환
     */
    public boolean defeated() {
        return baseballGamePolicy.defeated();
    }

    public String helloMessage() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public String askMessage() {
        return "숫자를 입력해주세요 : ";
    }

    public String successMessage() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public String restartMessage() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
