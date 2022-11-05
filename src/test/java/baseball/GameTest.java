package baseball;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    Game game = new Game();

    public Balls makeTestBalls(int ballOne, int ballTwo, int ballThree) {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(ballOne));
        balls.add(new Ball(ballTwo));
        balls.add(new Ball(ballThree));

        return new Balls(balls);
    }

    @Test
    void checkNothing() {
        Balls playerBalls = makeTestBalls(1, 2, 3);
        Balls computerBalls = makeTestBalls(4, 5, 6);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 0);
        assertEquals(game.ball, 0);
        assertEquals(game.printMessage(), "낫싱");
    }

    @Test
    void checkOneBallOneStrike() {
        Balls playerBalls = makeTestBalls(2, 1, 3);
        Balls computerBalls = makeTestBalls(2, 3, 7);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 1);
        assertEquals(game.ball, 1);
        assertEquals(game.printMessage(), "1볼 1스트라이크");
    }

    @Test
    void checkTwoBallOneStrike() {
        Balls playerBalls = makeTestBalls(2, 1, 3);
        Balls computerBalls = makeTestBalls(2, 3, 1);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 1);
        assertEquals(game.ball, 2);
        assertEquals(game.printMessage(), "2볼 1스트라이크");
    }

    @Test
    void checkThreeBall() {
        Balls playerBalls = makeTestBalls(2, 1, 3);
        Balls computerBalls = makeTestBalls(3, 2, 1);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 0);
        assertEquals(game.ball, 3);
        assertEquals(game.printMessage(), "3볼");
    }

    @Test
    void checkOneStrike() {
        Balls playerBalls = makeTestBalls(2, 1, 3);
        Balls computerBalls = makeTestBalls(2, 5, 7);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 1);
        assertEquals(game.ball, 0);
        assertEquals(game.printMessage(), "1스트라이크");
    }

    @Test
    void checkTwoStrike() {
        Balls playerBalls = makeTestBalls(2, 1, 3);
        Balls computerBalls = makeTestBalls(2, 1, 7);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 2);
        assertEquals(game.ball, 0);
        assertEquals(game.printMessage(), "2스트라이크");
    }

    @Test
    void checkThreeStrike() {
        Balls playerBalls = makeTestBalls(2, 1, 3);
        Balls computerBalls = makeTestBalls(2, 1, 3);
        game.checkBallCounts(playerBalls, computerBalls);
        assertEquals(game.strike, 3);
        assertEquals(game.ball, 0);
        assertEquals(game.printMessage(), "3스트라이크");
    }

    @Test
    void checkMakeComputerBalls() {
        Balls comBalls = game.makeComputerBalls();
        assertEquals(comBalls.size(), 3);
    }

}
