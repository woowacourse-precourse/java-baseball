package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                messageHolder.printAskRestart();
                playerRestart = messageHolder.getPlayerRestartInput();
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
        messageHolder.printAskGameInput();
        int playerNum = messageHolder.playerGameInputToInt(messageHolder.GetGameInput());
        game.compareListAndAnswer(intToList(playerNum));
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

    private static List<Integer> intToList(int playerNum) {
        List<Integer> playerList = new ArrayList<>();
        int num = playerNum;

        while (num > 0) {
            playerList.add(num % 10);
            num /= 10;
        }

        Collections.reverse(playerList);
        return playerList;
    }
}
