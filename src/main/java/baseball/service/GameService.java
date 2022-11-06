package baseball.service;

import baseball.domain.baseball.Baseballs;
import baseball.domain.game.Result;

public class GameService {
    public Result progress(Baseballs baseballs1, Baseballs baseballs2) {
        int strike = baseballs1.getStrike(baseballs2);
        int ball = baseballs1.getBall(baseballs2);

        return new Result(ball, strike);
    }
}
