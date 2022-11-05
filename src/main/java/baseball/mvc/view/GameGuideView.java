package baseball.mvc.view;

public enum GameGuideView {
    START("숫자 야구 게임을 시작합니다."),

    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    GameGuideView(String message) {
        this.message = message;
    }

    public void printGuideLog() {
        System.out.println(this.message);
    }
}
