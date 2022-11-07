package computer;

import iosystem.TryValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("랜덤한 3자리 수 생성 100회 반복하고 올바른 랜덤함수 형식인지 검증")
    void inputFourNumberTest() {
        // given
        List<Integer> randomThreeNumberList = RandomGenerator.generateDistinctThreeRandomNumber();

        // when
        String randomThreeNumberString = randomThreeNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(randomThreeNumberString);

        // then
        Assertions.assertAll(
                () -> assertDoesNotThrow(()->TryValidator.validate(randomThreeNumberString))
        );
    }
}