package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.SystemMessage.*;

public class GameController {

    public static final String RESTART_STATEMENT = "1";
    public static final String END_STATEMENT = "2";
    private final Player player;
    private final Opponent opponent;
    private final Referee referee;

    public GameController() {
        this.player = new Player();
        this.opponent = new Opponent();
        this.referee = new Referee();
    }

    public void run() {
        System.out.println(START_GAME);
        do {
            readyForGame();
            startGame();
        } while (restartGame());
    }

    private void readyForGame() {
        referee.saveOpponentAnswer(opponent.createAnswer());
    }

    private void startGame() {
        do {
            referee.CaculateResult(player.getAnswer());
            System.out.println(referee.getResult());
        } while (!referee.isAllStrike());
    }

    private String inputStatementNumber() {
        System.out.println(STRIKE_AND_GAME_OVER);
        System.out.println(REQUEST_RESTART_OR_GAME_OVER);
        return Console.readLine();
    }

    private boolean restartGame() {
        String inputStatement = inputStatementNumber();
        validateStatement(inputStatement);
        return inputStatement.equals(RESTART_STATEMENT);
    }

    private void validateStatement(String command) {
        if (!command.equals(RESTART_STATEMENT) && !command.equals(END_STATEMENT)) {
            throw new IllegalArgumentException(INVALID_STATEMENT);
        }
    }
}
