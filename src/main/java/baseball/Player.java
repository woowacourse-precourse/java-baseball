package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    Player() {
        this.numbers = new ArrayList<>();
    }

    Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void changeNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isPossiblePlay() {
        return numbers != null;
    }
}