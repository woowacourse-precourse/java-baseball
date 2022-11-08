package baseball.view;

public class PlayGameAgainResultView extends View {
    private final int input;
    private boolean response = false;

    public PlayGameAgainResultView(int input) {
        this.input = input;
    }

    @Override
    public void show() {
        if (this.input == 2) {
            printLine("게임 종료");
            this.response = false;

            return;
        }

        this.response = true;
    }

    @Override
    public boolean getResponseToBoolean() {
        return this.response;
    }
}
