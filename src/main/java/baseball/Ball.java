package baseball;

import java.util.List;

public class Ball {
    private final List<Integer> player;
    private final List<Integer> computer;
    private int count;

    public Ball(List<Integer> player, List<Integer> computer) {
        this.player = player;
        this.computer = computer;
        this.count = 0;
    }

    public int getCount() {
        for (Integer playerNumber : player) {
            if (isBall(playerNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBall(Integer number) {
        return computer.contains(number)
                && (computer.indexOf(number) != player.indexOf(number));
    }
}
