package baseball;

import java.util.List;

public class Strike {
    private final List<Integer> player;
    private final List<Integer> computer;
    private static final int INPUT_LENGTH = 3;
    private int count;

    public Strike(List<Integer> player, List<Integer> computer) {
        this.player = player;
        this.computer = computer;
        this.count = 0;
    }

    public int getCount() {
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (isStrike(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStrike(int index) {
        Integer number = player.get(index);
        return number.equals(computer.get(index));
    }
}
