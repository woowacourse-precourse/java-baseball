package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private int strike;
    private int ball;

    private List<Integer> computer;

    public Game() {
    }

    public void initGame() {
        this.strike = 0;
        this.ball = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        this.computer = Input.generateNumbers();
        while (precede()) ;
    }

    private boolean precede() {
        List<Integer> guess = Input.getInput();

        getStrikeAndBallCount(guess);

        Score result = getResult();
        if (result == Score.COMPLETE) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (result == Score.NOBALLSTRIKE) {
            System.out.println("낫싱");
        } else if (result == Score.NOBALL) {
            System.out.println(strike + "스트라이크");
        } else if (result == Score.NOSTRIKE) {
            System.out.println(ball + "볼");
        } else if (result == Score.DEFAULT) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return true;
    }

    private Score getResult() {
        if (strike == 3) return Score.COMPLETE;
        if (ball == 0 && strike == 0) return Score.NOBALLSTRIKE;
        if (ball == 0) return Score.NOBALL;
        if (strike == 0) return Score.NOSTRIKE;
        return Score.DEFAULT;
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
