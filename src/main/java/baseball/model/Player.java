package baseball.model;

import static baseball.util.InputUtility.parsingNumber;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Baseball> defend() {
        LinkedHashSet<Baseball> baseballSet = new LinkedHashSet<>();
        while (baseballSet.size() < 3) {
            baseballSet.add(new Baseball());
        }
        return new ArrayList<>(baseballSet);
    }

    public List<Baseball> attack(String input) {
        return parsingNumber(input).stream().map(Baseball::new).collect(Collectors.toList());
    }
}
