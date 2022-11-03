package baseball.service;

import baseball.model.GameNumber;
import baseball.model.Umpire;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private GameNumber computerGameNumber;

    public void newGame() {
        computerGameNumber = new GameNumber(numberGenerator.createRandomNumbers());
    }

    public Umpire playGame(String playerInputNumbers) {
        GameNumber playerGameNumber = new GameNumber(convertToList(playerInputNumbers));
        List<Integer> playerNumbers = playerGameNumber.getNumbers();
        List<Integer> computerNumbers = computerGameNumber.getNumbers();

        for (Integer computerNumber : computerNumbers) {
            System.out.print(computerNumber + " ");
        }
        System.out.println();
        return calculateMatchScore(playerNumbers, computerNumbers);
    }

    private Umpire calculateMatchScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int gameCount = 0; gameCount < 3; gameCount++) {
            int playerPeek = playerNumbers.get(gameCount);
            int computerPeek = computerNumbers.get(gameCount);

            if (playerPeek == computerPeek) {
                strike++;
                continue;
            }
            if (computerNumbers.contains(playerPeek)) {
                ball++;
            }
        }

        return new Umpire(ball, strike);
    }


    private List<Integer> convertToList(String playerInputNumbers) {
        return Arrays.stream(playerInputNumbers.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
