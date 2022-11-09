package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

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
    
    

    @Test
    void grading_낫싱() {
        Grade grade = new Grade(0, 0);
        Grade output = Application.grading(randomInt, 456);
        assertThat(grade).isEqualTo(output);
    }

    @Test
    void grading_3볼() {
        Grade grade = new Grade(3, 0);
        Grade output = Application.grading(randomInt, 312);
        assertThat(grade).isEqualTo(output);
    }

    @Test
    void grading_1볼_1스트라이크() {
        Grade grade = new Grade(1, 1);
        Grade output = Application.grading(randomInt, 134);
        assertThat(grade).isEqualTo(output);
    }

    @Test
    void grading_3스트라이크() {
        Grade grade = new Grade(0, 3);
        Grade output = Application.grading(randomInt, 123);
        assertThat(grade).isEqualTo(output);
    }

    @Test
    void makeGradeMessage_0볼_0스트라이크() {
        Grade grade = new Grade(0, 0);
        String message = Application.makeGradeMessage(grade);
        assertThat(message).isEqualTo("낫싱");
    }

    @Test
    void makeGradeMessage_1볼_0스트라이크() {
        Grade grade = new Grade(1, 0);
        String message = Application.makeGradeMessage(grade);
        assertThat(message).isEqualTo("1볼");
    }

    @Test
    void makeGradeMessage_0볼_1스트라이크() {
        Grade grade = new Grade(0, 1);
        String message = Application.makeGradeMessage(grade);
        assertThat(message).isEqualTo("1스트라이크");
    }

    @Test
    void makeGradeMessage_1볼_1스트라이크() {
        Grade grade = new Grade(1, 1);
        String message = Application.makeGradeMessage(grade);
        assertThat(message).isEqualTo("1볼 1스트라이크");
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
