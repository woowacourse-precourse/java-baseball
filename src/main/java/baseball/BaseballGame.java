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

        while (isPlaying) {
            textForGame.inputText();
            String input = Console.readLine();
            offenceNumber = validationNumber.checkAndConvertIntegerList(input);

            int strike = checkStrike(defenceNumber, offenceNumber);
            int ball = checkBall(defenceNumber, offenceNumber);
        }
    }

    public int checkStrike(List<Integer> defenceNumber, List<Integer> offenceNumber) {
        int count = 0;

        for (int i = 0; i < GAME_NUMBER_SIZE; i++) {
            if (defenceNumber.get(i).equals(offenceNumber.get(i))) {
                count++;
            }
        }

        return count;
    }

    public int checkBall(List<Integer> defenceNumber, List<Integer> offenceNumber) {
        int count = 0;

        for(Integer number : offenceNumber) {
            int index = defenceNumber.indexOf(number);
            if(index != -1 && offenceNumber.indexOf(number) != index) {
                count++;
            }
        }
        return count;
    }
}
