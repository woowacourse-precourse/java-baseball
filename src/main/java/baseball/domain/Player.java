package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    List<Integer> numbers = new ArrayList<>(Collections.emptyList());

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}