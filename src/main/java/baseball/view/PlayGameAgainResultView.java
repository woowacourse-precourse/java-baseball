package baseball.view;

public class PlayGameAgainResultView extends View {
    private final boolean isQuit;

    public PlayGameAgainResultView(boolean isQuit) {
        this.isQuit = isQuit;
    }

    @Override
    public void show() {
        if (this.isQuit) {
            printLine("게임 종료");
        }
    }
}
