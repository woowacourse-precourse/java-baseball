package baseball.objects;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    public void sayNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
