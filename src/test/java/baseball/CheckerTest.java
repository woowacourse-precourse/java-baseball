package baseball;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import baseball.checker.Checker;

public class CheckerTest {
    @Test
    void 게임중_숫자입력_유효성확인1(){
        String str = "554";
        Checker c = new Checker();
        assertThat(c.IsInvalidInput(str)).isEqualTo(true);
    }

    @Test
    void 게임중_숫자입력_유효성확인2(){
        String str = "3741";
        Checker c = new Checker();
        assertThat(c.IsInvalidInput(str)).isEqualTo(true);
    }

    @Test
    void 게임후_선택_유효성확인1(){
        String str = "3";
        Checker c = new Checker();
        assertThat(c.IsInvalidChoice(str)).isEqualTo(true);
    }

    @Test
    void 게임후_선택_유효성확인2(){
        String str = "kk";
        Checker c = new Checker();
        assertThat(c.IsInvalidChoice(str)).isEqualTo(true);
    }

    @Test
    void 사용자입력과_정답_비교확인1(){
        String user = "452";
        String answer = "532";
        Checker c = new Checker();
        assertThat(c.CompareUserInputWithAnswer(user, answer)).isEqualTo(-1);
    }

    @Test
    void 사용자입력과_정답_비교확인2(){
        String user = "452";
        String answer = "452";
        Checker c = new Checker();
        assertThat(c.CompareUserInputWithAnswer(user, answer)).isEqualTo(1);
    }
}
