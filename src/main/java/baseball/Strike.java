package baseball;

import java.util.List;

public class Strike {
    private final List<Integer> player;
    private final List<Integer> computer;

    public Strike(List<Integer> player, List<Integer> computer) {
        this.player = player;
        this.computer = computer;
    }

    private boolean isStrike(int index) {
        Integer number = player.get(index);
        return number.equals(computer.get(index));
    }
}
