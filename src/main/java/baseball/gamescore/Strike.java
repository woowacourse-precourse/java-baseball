package baseball.gamescore;

import java.util.List;

public class Strike {
    public int score(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int playerIndex = 0; playerIndex < player.size(); playerIndex++) {
            int playerNumber = player.get(playerIndex);
            if (computer.get(playerIndex) == playerNumber) {
                strike++;
            }
        }
        return strike;
    }
}
