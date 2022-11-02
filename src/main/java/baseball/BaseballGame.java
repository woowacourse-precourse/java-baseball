package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {

    public static final int GAME_NUMBER_SIZE = 3;
    private boolean isPlaying = false;

    public void startAndPlaying() {
        ValidationNumber validationNumber = new ValidationNumber(GAME_NUMBER_SIZE);
        DefenceNumber defenceNumberMaker = new DefenceNumber(GAME_NUMBER_SIZE);
        TextForGame textForGame = new TextForGame();
        isPlaying = true;

        List<Integer> defenceNumber = defenceNumberMaker.getDefenceNumber();
        List<Integer> offenceNumber;

        while(isPlaying) {
            textForGame.inputText();
            String input = Console.readLine();
            offenceNumber = validationNumber.checkAndConvertIntegerList(input);
        }
    }
}
