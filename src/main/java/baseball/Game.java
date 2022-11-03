package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Integer> computerAnswer;
    private int currentBall;
    private int currentStrike;

    public void init() {
        computerAnswer = new ArrayList<>();

        addThreeNumberToComputerAnswer();

        currentBall = 0;
        currentStrike = 0;
    }

    private void addThreeNumberToComputerAnswer() {
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumberToComputerAnswer(randomNumber);
        }
    }

    private void addNumberToComputerAnswer(int randomNumber) {
        if (!computerAnswer.contains(randomNumber)) {
            computerAnswer.add(randomNumber);
        }
    }

    public void comparePlayerInputAndAnswer(int playerNum) {
        currentBall = 0;
        currentStrike = 0;
        List<Integer> player_list = new ArrayList<>();
        intToList(playerNum, player_list);
        compareListAndAnswer(player_list);
    }

    private void compareListAndAnswer(List<Integer> player_list) {
        for (int indexNum = 0; indexNum < 3; indexNum++) {
            compareValue(player_list, indexNum);
        }
    }

    private void compareValue(List<Integer> player_list, int indexNum) {
        if (player_list.get(indexNum) == computerAnswer.get(indexNum))
            currentStrike++;

        else if (computerAnswer.contains(player_list.get(indexNum)))
            currentBall++;
    }

    private void intToList(int playerNum, List<Integer> playerList) {
        int num = playerNum;

        while (num > 0) {
            playerList.add(num % 10);
            num /= 10;
        }

        Collections.reverse(playerList);
    }

    public int getStrike() {
        return currentStrike;
    }

    public int getBall() {
        return currentBall;
    }

}
