package baseball.domain.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseballs {
    private static final int BASEBALL_NUMBER = 3;

    private List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs) {
        this.baseballs = baseballs;
    }

    public List<Baseball> getBaseballs() {
        return baseballs;
    }

    public static Baseballs random() {
        Set<Baseball> randomBaseBalls = new HashSet<>();

        while (randomBaseBalls.size() < BASEBALL_NUMBER) {
            randomBaseBalls.add(Baseball.random());
        }

        return new Baseballs(new ArrayList<>(randomBaseBalls));
    }
}
