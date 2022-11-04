package baseball.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Input {
    private final List<Integer> baseballNumberList;

    public Input(String input){
        IntStream charStream = input.chars();
        baseballNumberList = charStream
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getBaseballNumberList() {
        return baseballNumberList;
    }
}