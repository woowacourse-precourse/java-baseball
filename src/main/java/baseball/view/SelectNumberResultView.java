package baseball.view;

import baseball.service.GameService;
import baseball.vo.Scoreboard;

public class SelectNumberResultView extends View {
    private final int number;
    private Boolean response = false;

    public SelectNumberResultView(int number) {
        this.number = number;
    }

    @Override
    public void show() {
        GameService service = new GameService();
        Scoreboard scoreboard = service.compareComputerNumberWith(this.number);

        if (scoreboard.getStrikePoint() == 3 && scoreboard.getBallPoint() == 0) {
            this.response = service.deleteComputerNumber(number);
        }

        printLine(scoreboard.toString());
    }

    @Override
    public boolean getResponseToBoolean() {
        return this.response;
    }
}