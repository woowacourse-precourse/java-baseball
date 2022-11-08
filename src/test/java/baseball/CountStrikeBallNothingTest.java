package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountStrikeBallNothingTest extends NsTest {

    @Test
    void 스트라이크_테스트() {
        Game game = new Game(new Computer(), new User());

        String printMent = game.getScoreMent("123", "123");

        Assertions.assertEquals(printMent, "3스트라이크");
    }

    @Test
    void 볼_테스트() {
        Game game = new Game(new Computer(), new User());

        String printMent = game.getScoreMent("431", "213");

        Assertions.assertEquals(printMent, "2볼 ");
    }

    @Test
    void 낫싱_테스트() {
        Game game = new Game(new Computer(), new User());

        String printMent = game.getScoreMent("123", "456");

        Assertions.assertEquals(printMent, "낫싱");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
