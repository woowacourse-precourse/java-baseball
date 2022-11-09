package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    List<Integer> randomInt = new ArrayList<>();

    @BeforeEach
    void randomInt_값추가() {
        randomInt.add(1);
        randomInt.add(2);
        randomInt.add(3);
    }
    
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void getRandomIntList_사이즈3_반환확인() {
        List<Integer> list = Application.getRandomIntList();
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void getInputInt_정상입력() {
        assertThat(Application.getInputInt("123")).isEqualTo(123);
    }
    
//    @Test
//    void validateInput_길이_3미만() {
//        assertThatThrownBy(() -> Application.validateInput("12"))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("잘못된 입력!");
//    }
//
//    @Test
//    void validateInput_길이_3초과() {
//        assertThatThrownBy(() -> Application.validateInput("1234"))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("잘못된 입력!");
//    }
//
//    @Test
//    void validateInput_입력범위_초과() {
//        assertThatThrownBy(() -> Application.validateInput("Abc"))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("잘못된 입력!");
//    }
//
//    @Test
//    void validateInput_중복숫자_입력() {
//        assertThatThrownBy(() -> Application.validateInput("112"))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("잘못된 입력!");
//    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "Abc", "112"})
    void validateInput_길이제한_잘못된문자_중복숫자(String input) {
        assertThatThrownBy(() -> Application.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력!");
    }

    @ParameterizedTest
    @MethodSource("provideBallAndStrike")
    void grading_여러(int ball, int strike, int inputInt) {
        Grade grade = new Grade(ball, strike);
        Grade output = Application.grading(randomInt, inputInt);
        assertThat(grade).isEqualTo(output);
    }

    private static Stream<Arguments> provideBallAndStrike() {
        return Stream.of(
                Arguments.of(0, 0, 456),
                Arguments.of(3, 0, 312),
                Arguments.of(1, 1, 134),
                Arguments.of(0, 3, 123)
        );
    }

    @ParameterizedTest
    @MethodSource("provideBallAndStrikeAndExpected")
    void makeGradeMessage_여러경우(int ball, int strike, String expected) {
        Grade grade = new Grade(ball, strike);
        String message = Application.makeGradeMessage(grade);
        assertThat(message).isEqualTo(expected);
    }
    private static Stream<Arguments> provideBallAndStrikeAndExpected() {
        return Stream.of(
                Arguments.of(0, 0, "낫싱"),
                Arguments.of(1, 0, "1볼"),
                Arguments.of(0, 1, "1스트라이크"),
                Arguments.of(1, 1, "1볼 1스트라이크")
        );
    }

    @Test
    void getChoice_1입력() {
        int choice = Application.getChoice("1");
        assertThat(choice).isEqualTo(1);
    }

    @Test
    void getChoice_2입력() {
        int choice = Application.getChoice("2");
        assertThat(choice).isEqualTo(2);
    }

    @Test
    void getChoice_예외입력() {

        assertThatThrownBy(() -> Application.getChoice("예외"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력!");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
