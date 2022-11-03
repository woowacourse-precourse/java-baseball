package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static final int GAME_NUMBER_SIZE = 3;

    public static final int BALL_INDEX = 0;
    public static final int STRIKE_INDEX = 1;

    public static final int RESTART = 1;
    public static final int END = 2;


    StrikeAndBall strikeAndBall;
    User user;
    TextForGame textForGame;
    List<Integer> result;
    boolean isPlaying;


    BaseballGame() {
        strikeAndBall = new StrikeAndBall(GAME_NUMBER_SIZE);
        user = new User(GAME_NUMBER_SIZE);
        textForGame = new TextForGame();
        result = new ArrayList<>();
    }

    public void startAndPlaying() {
        isPlaying = true;
        strikeAndBall.setDefenceNumber();

        while(isPlaying) {
            textForGame.inputText();
            List<Integer> offenceNumber = user.inputGameNumber();
            strikeAndBall.setOffenceNumber(offenceNumber);

            result = strikeAndBall.getBallAndStrikeCount();

            textForGame.printResult(result.get(BALL_INDEX), result.get(STRIKE_INDEX));

            if(result.get(STRIKE_INDEX) == GAME_NUMBER_SIZE) {
                endOrRestart();
            }
        }
    }

    public void endOrRestart() {
        textForGame.printEndAndAskAboutNewGame();
        String numberString = user.inputEndOrRestart();
        int number = Integer.parseInt(numberString);

        if(number == END) {
            isPlaying = false;
        }
        if(number == RESTART) {
            startAndPlaying();
        }
    }
}
