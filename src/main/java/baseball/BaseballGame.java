package baseball;

import java.util.List;

public class BaseballGame {

    public static final int GAME_NUMBER_SIZE = 3;
    private boolean isPlaying = false;

    public void startAndPlaying() {
        DefenceNumber defenceNumberMaker = new DefenceNumber(GAME_NUMBER_SIZE);
        TextForGame textForGame = new TextForGame();
        isPlaying = true;
        List<Integer> defenceNumber = defenceNumberMaker.getDefenceNumber();

        while(isPlaying) {
            textForGame.inputText();

        }
    }
}
