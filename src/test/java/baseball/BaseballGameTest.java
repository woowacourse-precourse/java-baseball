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

    @Test()
    void 유효한_문자열_확인_1() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when, then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> baseballGame.checkValidString(" 123"));
    }

    @Test()
    void 유효한_문자열_확인_2() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when, then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> baseballGame.checkValidString("abcd"));
    }

    @Test()
    void 유효한_문자열_확인_3() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when, then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> baseballGame.checkValidString("1234"));
    }

    @Test()
    void 유효한_문자열_확인_4() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when, then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> baseballGame.checkValidString("v5q"));
    }

    @Test()
    void 유효한_문자열_확인_5() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when, then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> baseballGame.checkValidString("45 671"));
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
