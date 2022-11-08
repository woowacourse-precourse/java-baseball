package baseball.model;

import baseball.service.GameService;

import java.util.List;

public class Game {

    private GameService gameService = new GameService();

    private List<Integer> numbers;

    public Game() {
    }

    public Game(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean compare(Game userInput) {
        return gameService.compareAnswer(this.numbers, userInput.numbers);
    }
}
