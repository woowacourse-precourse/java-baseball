package baseball;

import baseball.domain.Baseball;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {
    @Test
    void 정상적인_3자리_숫자_입력() {
        List<Integer> list = List.of(1, 2, 3);
        Baseball baseball = new Baseball();
        List<Integer> result = baseball.setUserNumber("123");
        assertThat(result).isEqualTo(list);
    }

    @Test
    void 한자리_숫자_입력() {
        Baseball baseball = new Baseball();
        assertThrows(IllegalArgumentException.class, () -> {
            baseball.setUserNumber("1");
        });
    }

    @Test
    void 한자리_문자_입력() {
        Baseball baseball = new Baseball();
        assertThrows(IllegalArgumentException.class, () -> {
            baseball.setUserNumber("a");
        });
    }

    @Test
    void 문자_숫자_섞어서_입력() {
        Baseball baseball = new Baseball();
        assertThrows(IllegalArgumentException.class, () -> {
            baseball.setUserNumber("1a3");
        });
    }

    @Test
    void 같은_숫자_입력() {
        Baseball baseball = new Baseball();
        assertThrows(IllegalArgumentException.class, () -> {
            baseball.setUserNumber("131");
        });
    }

}