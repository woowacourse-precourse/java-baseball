package baseball;

import java.util.List;

public class Game {
    public static int GAME_LENGTH = 3;

    private final int GAME_RESTART_VALUE = 1;
    private final int GAME_END_VALUE = 2;

    private Referee referee;
    private Catcher catcher;
    private Pitcher pitcher;
    private List<Integer> catcherNumbers;
    private boolean flagGameProcess = true;

    public Game(Referee referee, Catcher catcher, Pitcher pitcher) {
        this.referee = referee;
        this.catcher = catcher;
        this.pitcher = pitcher;
    }
}
