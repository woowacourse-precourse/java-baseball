package baseball.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.util.Random.generateIntegers;

public class Pitch {
    private List<Integer> pitches;

    public Pitch() {
        this.pitches = List.of(1, 2, 3);
    }

    public Pitch random() {
        this.pitches = generateIntegers(3);
        return this;
    }
}
