package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void create() {
        Numbers numbers = new Numbers(1, 2, 3);

        assertThat(numbers).isEqualTo(new Numbers(1, 2, 3));
    }

    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼을 저장한 힌트 콜렉션을 얻는다.")
    @Test
    void match() {
        Numbers numbers = new Numbers(5, 7, 2);

        assertThat(numbers.match(new Numbers(2, 7, 5)))
                .isEqualTo(new Hints(List.of(Hint.BALL, Hint.STRIKE, Hint.BALL)));
    }
}
