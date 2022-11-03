package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        MessageHolder messageHolder = new MessageHolder();
        gameStart(game, messageHolder);

    }

    private static void gameStart(Game game, MessageHolder messageHolder) {
        boolean isInGame = true;
        int playerRestart = -1;
        setGameStart(game, messageHolder);

        while (isInGame) {

            isInGame = inGame(game, messageHolder);

            if (!isInGame) {
                playerRestart = messageHolder.printAskRestartAndGetInput();
            }

            if (playerRestart == 2) {
                isInGame = false;
                break;
            } else if (playerRestart == 1) {
                isInGame = true;
                playerRestart = -1;
                setGameStart(game, messageHolder);
            }

        }
    }

    private static boolean inGame(Game game, MessageHolder messageHolder) {
        int playerNum = messageHolder.printGetGameInput();
        game.comparePlayerInputAndAnswer(playerNum);
        int currentBall = game.getBall();
        int currentStrike = game.getStrike();
        messageHolder.printBallAndStrike(currentBall, currentStrike);

        if (currentStrike == 3)
            return false;

        return true;
    }

    private static void setGameStart(Game game, MessageHolder messageHolder) {
        game.init();
        messageHolder.printStartMessage();
    }
}
