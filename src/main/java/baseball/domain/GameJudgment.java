package baseball.domain;

import java.util.List;

public class GameJudgment {

    public int compare(List<Integer> computer, List<Integer> player) {
        int correctCount = 0;
        for (int playerIndex = 0; playerIndex < player.size(); playerIndex++) {
            Integer playerNumber = player.get(playerIndex);

            if (computer.contains(playerNumber)) {
                correctCount++;
            }
        }
        return correctCount;
    }
}
