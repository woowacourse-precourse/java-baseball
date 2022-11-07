package baseball.model;

import baseball.model.HomeRun;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeRunTest {
    @Test
    void createHomeRun() {
        HomeRun homeRun = new HomeRun();
        TestCreateStrategy homeRunStrategy = new TestCreateStrategy();
        assertEquals(homeRun.homeRun(homeRunStrategy), List.of(BallNumber.ballNumber('1'), BallNumber.ballNumber('2'), BallNumber.ballNumber('3')));
    }
}
