package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;

    public void writeNumber(String input){
        this.numbers = Arrays.stream(input.split("")).
                map(Integer::valueOf).
                collect(Collectors.toList());
    }

    public int getIndexNumber(int idx){
        return numbers.get(idx);
    }
}
