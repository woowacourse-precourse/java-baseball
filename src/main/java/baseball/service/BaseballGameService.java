package baseball.service;

import baseball.model.GameNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private GameNumber computerGameNumber;

    public void newGame() {
        computerGameNumber = new GameNumber(numberGenerator.createRandomNumbers());
    }

    public void playGame(String playerInputNumbers) {
        GameNumber playerGameNumber = new GameNumber(convertToList(playerInputNumbers));
        List<Integer> playerNumbers = playerGameNumber.getNumbers();
        List<Integer> computerNumbers = computerGameNumber.getNumbers();

        List<Integer> gameResult = playerNumbers.stream()
                .map(computerNumbers::indexOf)
                .collect(Collectors.toList());
    }


    private List<Integer> convertToList(String playerInputNumbers) {
        return Arrays.stream(playerInputNumbers.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
