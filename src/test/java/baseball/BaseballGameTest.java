package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    void 랜덤한_3개의_숫자_리스트_생성() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        List<Integer> list = baseballGame.getRandomNumberList();

        // then
        Assertions.assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void 문자열_길이가_3인_경우_1() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isStringLengthThree("123");

        // then
        Assertions.assertThat(check).isEqualTo(true);
    }

    @Test
    void 문자열_길이가_3인_경우_2() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isStringLengthThree("1b3");

        // then
        Assertions.assertThat(check).isEqualTo(true);
    }

    @Test
    void 문자열_길이가_3인_경우_3() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isStringLengthThree("abc");

        // then
        Assertions.assertThat(check).isEqualTo(true);
    }

    @Test
    void 문자열_길이가_3이_아닌_경우_1() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isStringLengthThree("");

        // then
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    void 문자열_길이가_3이_아닌_경우_2() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isStringLengthThree("1234");

        // then
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    void 문자열_길이가_3이_아닌_경우_3() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isStringLengthThree("a23dq");

        // then
        Assertions.assertThat(check).isEqualTo(false);
    }
}
