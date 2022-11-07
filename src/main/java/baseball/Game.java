package baseball;

public class Game {

    private static final int ENDGAME = 2;
    private static final int FIRST_START_OFGAME = 0;
    private static final int NOT_FIRST_START_OFGAME = 1;
    private static final int PLAYAGAINMODE = 2;

    public static void start(int firstCheck) {
        User user = new User();
        Screen screen = new Screen();
        Referee referee = new Referee();
        if (firstCheck == FIRST_START_OFGAME) {
            screen.printGameStart();
            progress(user, screen, referee);
        } else if (firstCheck == NOT_FIRST_START_OFGAME) {
            progress(user, screen, referee);
        }
    }

    private static void progress(User user, Screen screen, Referee referee) {
        while (true) {
            screen.printInputNumber();
            String RefereeResult = screen.printCalculateResult(
                referee.calculateAnswer(user.inputValue(1)));
            if (RefereeResult.equals("3스트라이크") && (checkContinueMode(user, screen) == ENDGAME)) {
                break;
            }
        }
    }

    private static int checkContinueMode(User user, Screen screen) {
        screen.printEndingMessage();
        if (user.inputValue(PLAYAGAINMODE).equals("1")) {
            Game game = new Game();
            game.start(NOT_FIRST_START_OFGAME);
        }
        return ENDGAME;
    }

}
