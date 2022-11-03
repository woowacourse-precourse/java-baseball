package baseball.service;

import baseball.model.GameNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();

    public void playGame(String playerInputNumbers) {
        GameNumber computerNumbers = new GameNumber(numberGenerator.createRandomNumbers());
        GameNumber playerNumbers = new GameNumber(convertToList(playerInputNumbers));

        
    }

    private List<Integer> convertToList(String playerInputNumbers) {
        return Arrays.stream(playerInputNumbers.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }
}
