package baseball;

import baseball.domain.Validator;
import baseball.domain.game.baseball.CreateBaseBall;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    CreateBaseBall game = new CreateBaseBall();

    @Test
    void validatorRandomNumber(){
        String randomNumber = game.generateRandomNumber();
        String comparedRandomNumber = game.generateRandomNumber();
        assertThat(randomNumber).isNotEqualTo(comparedRandomNumber);
    }

    @Test
    void 세자리_넘어가는_숫자를_입력한_경우_예외를_반환(){
        Validator validator= new Validator();
        String input = "1234";

        assertThatThrownBy(() -> validator.validateRandomNumberExceedLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력해주세요");
    }

    @Test
    void 문자를_포함하여_입력한_경우_예외를_반환(){
        Validator validator= new Validator();
        String input = "a12";

        assertThatThrownBy(() -> validator.validateContainChar(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력해주세요");
    }

    @Test
    void 공백을_포함하여_입력한_경우_예외를_반환(){
        Validator validator= new Validator();
        String input = "1 23";

        assertThatThrownBy(() -> validator.validateContainBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력해주세요");
    }

    @Test
    void 영을_포함하여_입력한_경우_예외를_반환(){
        Validator validator= new Validator();
        String input = "103";

        assertThatThrownBy(() -> validator.validateContainZero(input))
                .isInstanceOf(IllegalArgumentException.class);
//                .hasMessageContaining("0을 입력하지 마세요");
    }




    @Test
    void 랜덤_숫자_크기가_3인지_확인(){
        String randomNumber = game.generateRandomNumber();
        assertThat(randomNumber).hasSize(3);
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

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
