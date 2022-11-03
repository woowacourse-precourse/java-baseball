package baseball;

import java.util.ArrayList;
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

    @Test
    void 문자열이_숫자만_있지_않은_경우_1() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isNumber("1b2");

        // then
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    void 문자열이_숫자만_있지_않은_경우_2() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isNumber("");

        // then
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    void 문자열이_숫자만_있지_않은_경우_3() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        boolean check = baseballGame.isNumber(" 12 3");

        // then
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    void 볼_개수와_스트라이크_개수를_통한_결과_문자열_3스트라이크() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        // when
        String resultString = baseballGame.getAnswerString(computer, user);

        // when
        Assertions.assertThat(resultString).isEqualTo("3스트라이크");
    }

    @Test
    void 볼_개수와_스트라이크_개수를_통한_결과_문자열_2볼_1스트라이크() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computer = List.of(3, 5, 8);
        List<Integer> user = List.of(3, 8, 5);

        // when
        String resultString = baseballGame.getAnswerString(computer, user);

        // when
        Assertions.assertThat(resultString).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_개수와_스트라이크_개수를_통한_결과_문자열_3볼() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computer = List.of(4, 2, 6);
        List<Integer> user = List.of(6, 4, 2);

        // when
        String resultString = baseballGame.getAnswerString(computer, user);

        // when
        Assertions.assertThat(resultString).isEqualTo("3볼");
    }

    @Test
    void 볼_개수와_스트라이크_개수를_통한_결과_문자열_2볼() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computer = List.of(4, 2, 6);
        List<Integer> user = List.of(6, 4, 1);

        // when
        String resultString = baseballGame.getAnswerString(computer, user);

        // when
        Assertions.assertThat(resultString).isEqualTo("2볼");
    }

    @Test
    void 볼_개수와_스트라이크_개수를_통한_결과_문자열_1볼() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computer = List.of(4, 2, 6);
        List<Integer> user = List.of(6, 1, 3);

        // when
        String resultString = baseballGame.getAnswerString(computer, user);

        // when
        Assertions.assertThat(resultString).isEqualTo("1볼");
    }

    @Test
    void 볼_개수와_스트라이크_개수를_통한_결과_문자열_낫싱() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computer = List.of(4, 2, 6);
        List<Integer> user = List.of(9, 8, 7);

        // when
        String resultString = baseballGame.getAnswerString(computer, user);

        // when
        Assertions.assertThat(resultString).isEqualTo("낫싱");
    }
}
