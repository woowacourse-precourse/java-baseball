package baseball;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    void 유저입력_예외_테스트() {
        List<String> errorCases = List.of(
                "", "1", "12", "1234",
                "112", "121", "111", "211",
                "가나다", "asd", "a가1", "12가",
                "13a", "!@#", " ", " 123",
                "9 7", "\n\t1", "\n123",
                "123\n", "\t132", "1234567489"
        );
        List<String> normalCases = List.of(
                "123", "456", "789",
                "987", "654", "321",
                "231", "132", "312"
        );
        for (String errorCase : errorCases) {
            User wrongInput = new User(errorCase);
            assertThatThrownBy(wrongInput::errorChecking).isInstanceOf(IllegalArgumentException.class);
        }
        for (String normalCase : normalCases) {
            User normalInput = new User(normalCase);
            assertThatCode(normalInput::errorChecking).doesNotThrowAnyException();
        }
    }

    @Test
    void 스트라이크_테스트() {
        User user = new User("456");
        List<List<Integer>> noStrikeCases = List.of(
                List.of(3, 1, 2), List.of(1, 3, 2), List.of(7, 8, 9),
                //1ball
                List.of(3, 4, 2), List.of(3, 4, 7), List.of(3, 5, 8),
                //2ball
                List.of(1, 4, 5), List.of(6, 4, 1), List.of(5, 6, 1),
                //3ball
                List.of(5, 6, 4), List.of(6, 4, 5)
        );
        List<List<Integer>> oneStrikeCases = List.of(
                //1strike
                List.of(4, 1, 2), List.of(1, 5, 2), List.of(1, 2, 6),
                //1strike 1ball
                List.of(4, 1, 5), List.of(4, 6, 1), List.of(1, 5, 4),
                List.of(6, 5, 1), List.of(1, 4, 6), List.of(5, 1, 6),
                //1strike 2ball
                List.of(4, 6, 5), List.of(6, 5, 4), List.of(5, 4, 6)
        );
        List<List<Integer>> twoStrikeCases = List.of(
                List.of(4, 5, 1), List.of(1, 5, 6), List.of(4, 1, 6)
        );
        List<Integer> threeStrike = List.of(4, 5, 6);

        for (List<Integer> noStrike : noStrikeCases) {
            assertThat(user.strike(noStrike)).isEqualTo(0);
        }
        for (List<Integer> oneStrike : oneStrikeCases) {
            assertThat(user.strike(oneStrike)).isEqualTo(1);
        }
        for (List<Integer> twoStrike : twoStrikeCases) {
            assertThat(user.strike(twoStrike)).isEqualTo(2);
        }
        assertThat(user.strike(threeStrike)).isEqualTo(3);
    }
    @Test
    void 볼_테스트() {
        User user = new User("456");
        List<List<Integer>> noBallCases = List.of(
                //nothing
                List.of(3, 1, 2), List.of(1, 3, 2), List.of(7, 8, 9),
                //1strike
                List.of(4, 1, 2), List.of(1, 5, 2), List.of(1, 2, 6),
                //2strike
                List.of(4, 5, 1), List.of(1, 5, 6), List.of(4, 1, 6),
                //3strike
                List.of(4, 5, 6)
        );
        List<List<Integer>> oneBallCases = List.of(
                //1ball
                List.of(5, 1, 2), List.of(1, 6, 2), List.of(1, 2, 5),
                //1strike 1ball
                List.of(4, 1, 5), List.of(4, 6, 1), List.of(1, 5, 4),
                List.of(6, 5, 1), List.of(1, 4, 6), List.of(5, 1, 6)

        );
        List<List<Integer>> twoBallCases = List.of(
                //2ball
                List.of(1, 4, 5), List.of(6, 4, 1), List.of(5, 6, 1),
                //1strike 2ball
                List.of(4, 6, 5), List.of(6, 5, 4), List.of(5, 4, 6)
        );
        List<List<Integer>> threeBallCases = List.of(
                List.of(5, 6, 4), List.of(6, 4, 5)
        );
        for (List<Integer> noBall : noBallCases) {
            assertThat(user.ball(noBall)).isEqualTo(0);
        }
        for (List<Integer> oneBall : oneBallCases) {
            assertThat(user.ball(oneBall)).isEqualTo(1);
        }
        for (List<Integer> twoBall : twoBallCases) {
            assertThat(user.ball(twoBall)).isEqualTo(2);
        }
        for (List<Integer> threeBall : threeBallCases) {
            assertThat(user.ball(threeBall)).isEqualTo(3);
        }
    }
}
