package baseball.view;

public class PlayGameAgainResult extends View {
    private final int input;
    private boolean response = false;

    public PlayGameAgainResult(int input) {
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
