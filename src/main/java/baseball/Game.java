package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private int strike;
    private int ball;

    private List<Integer> computer;

    public Game() {
    }

    private boolean precede() {
        this.computer = Input.generateNumbers();
        List<Integer> guess = Input.getInput();

        getStrikeAndBallCount(guess);

        return true;
    }

    private void getStrikeAndBallCount(List<Integer> guess) {
        this.strike = getStrikeIdx(guess).size();
        this.ball = getBallIdx(guess).size();
    }

    private List<Integer> getStrikeIdx(List<Integer> guess) {
        return IntStream.range(0, this.computer.size())
                .filter(i -> this.computer.get(i) == guess.get(i))
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> getBallIdx(List<Integer> guess) {
        List<Integer> strikeIdx = getStrikeIdx(guess);

        return IntStream.range(0, this.computer.size())
                .filter(i -> !strikeIdx.contains(i))
                .filter(i -> this.computer.contains(guess.get(i)))
                .boxed()
                .collect(Collectors.toList());
    }
}
