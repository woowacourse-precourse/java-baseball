package baseball.model;

import java.util.List;

public class Computer {
    private List<Integer> numbers;
    private int strikeCount;
    private int ballCount;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void initCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void incStrikeCount() {
        this.strikeCount++;
    }

    public void incBallCount() {
        this.ballCount++;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getNumber(int index) {
        return this.numbers.get(index);
    }

    public int getIndex(int value) {
        return this.numbers.indexOf(value);
    }

}