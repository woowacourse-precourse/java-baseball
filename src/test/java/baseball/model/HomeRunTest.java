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
        System.out.println(homeRun.homeRun(new HomeRunStrategy()));
        assertEquals(homeRun.homeRun(homeRunStrategy), List.of('1', '2', '3'));
    }
}
