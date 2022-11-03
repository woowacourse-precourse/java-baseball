package baseball.domain;

import baseball.util.ShowGameMessage;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    private final ShowGameMessage showGameMessage = new ShowGameMessage();
    private ScoreBoard scoreBoard;

    public void init() {
        scoreBoard = new ScoreBoard(initializeSystemNumberBall());
        showGameMessage.gameStartMessage();
    }

    private List<NumberBall> initializeSystemNumberBall() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.stream().map(NumberBall::new).collect(Collectors.toList());
    }
}