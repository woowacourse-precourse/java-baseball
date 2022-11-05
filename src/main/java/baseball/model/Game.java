package baseball.model;

import baseball.service.GameService;

import java.util.List;

public class Game {

    private List<Integer> numbers;

    public Game() {}

    public Game(List<Integer> numbers){
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
