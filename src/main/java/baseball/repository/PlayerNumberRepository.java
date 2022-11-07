package baseball.repository;

import baseball.model.gamenumber.PlayerNumber;
import java.util.List;

public class PlayerNumberRepository extends PlayerNumber {
    public PlayerNumberRepository(String numberString) {
        super(numberString);
    }

    @Override
    public List<Integer> getNumberList() {
        return super.getNumberList();
    }
}