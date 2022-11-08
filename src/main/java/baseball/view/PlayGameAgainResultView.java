package baseball.view;

public class PlayGameAgainResultView extends View {
    private final boolean isPlayAgain;

    public PlayGameAgainResultView(boolean isPlayAgain) {
        this.isPlayAgain = isPlayAgain;
    }

    @Override
    public void show() {
        if (!this.isPlayAgain) {
            printLine("게임 종료");
        }
    }
}
