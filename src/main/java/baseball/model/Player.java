package baseball.model;

import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void add(int value) {
        this.numbers.add(value);
    }

    public int getNumber(int index) {
        return this.numbers.get(index);
    }

    public int getIndex(int value) {
        return this.numbers.indexOf(value);
    }
}