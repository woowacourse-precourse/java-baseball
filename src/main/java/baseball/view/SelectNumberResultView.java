package baseball.view;

import baseball.service.GameService;
import baseball.vo.Scoreboard;

public class SelectNumberResultView extends View {
    private final Scoreboard scoreboard;

    public SelectNumberResultView(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public void show() {
        printLine(this.scoreboard.toString());
    }
}