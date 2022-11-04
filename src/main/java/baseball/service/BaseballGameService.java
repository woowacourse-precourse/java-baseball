package baseball.service;

import baseball.model.GameNumber;
import baseball.model.GameResult;
import baseball.model.Umpire;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private Umpire umpire;

    public void newGame() {
        GameNumber computerGameNumber = new GameNumber(numberGenerator.createRandomNumbers());
        umpire = new Umpire(computerGameNumber);
    }

    public GameResult playGame(String playerInputNumbers) {
        GameNumber playerGameNumber = new GameNumber(convertToList(playerInputNumbers));
        umpire.playerNewGameNumber(playerGameNumber);

        return umpire.decision();
    }



    private List<Integer> convertToList(String playerInputNumbers) {
        return Arrays.stream(playerInputNumbers.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
