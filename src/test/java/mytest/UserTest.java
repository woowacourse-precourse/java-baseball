package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.players.User;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class UserTest {
    @DisplayName("유효한 입력값에 대해 리스트를 반환하는지 확인")
    @Nested
    class ReturnTest {
        @Test
        void case1() {
            List<Integer> userNumber = User.splitToDigits("139");
            List<Integer> result = List.of(1, 3, 9);

            boolean isEqual = IntStream.range(0, userNumber.size())
                    .allMatch(index -> userNumber.get(index) == result.get(index));
            assertThat(isEqual).isTrue();
        }

        @Test
        void case2() {
            List<Integer> userNumber = User.splitToDigits("248");
            List<Integer> result = List.of(2, 4, 8);

            boolean isEqual = IntStream.range(0, userNumber.size())
                    .allMatch(index -> userNumber.get(index) == result.get(index));
            assertThat(isEqual).isTrue();
        }
    }
}
