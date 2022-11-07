package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

@DisplayName("User관련 테스트를 진행한다.")
class UserTest {

    @DisplayName("사용자의 입력을 받아 리스트로 반환하는 테스트를 진행한다.")
    @ParameterizedTest
    @CsvSource({"123, 1, 2, 3", "789, 7, 8, 9"})
    void 입력을_받으면_리스트로_반환된다(String input, int firstElement, int secondElement, int thirdElement) {
        //given
        User user = new User();
        //when
        List<Integer> result = user.toList(input);

        //then
        Assertions.assertThat(result).containsExactly(firstElement, secondElement, thirdElement);
    }

}