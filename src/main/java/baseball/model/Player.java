package baseball.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Player {
    public List<Baseball> defend() {
        LinkedHashSet<Baseball> baseballSet = new LinkedHashSet<>();
        while (baseballSet.size() < 3) {
            baseballSet.add(new Baseball());
        }
        return new ArrayList<>(baseballSet);
    }

}
