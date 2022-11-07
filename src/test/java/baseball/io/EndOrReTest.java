package baseball.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EndOrReTest {

    private EndOrRe endOrRe;

    @BeforeEach
    public void setEndOrTest() {
        endOrRe = new EndOrRe();
    }

    @Test
    void 입력된_값_확인1() {
        int oneOrTwo = endOrRe.printInputString("1");
        int result = 1;
        Assertions.assertThat(oneOrTwo).isEqualTo(result);
    }

    @Test
    void 입력된_값_확인2() {
        int oneOrTwo = endOrRe.printInputString("2");
        int result = 2;
        Assertions.assertThat(oneOrTwo).isEqualTo(result);
    }

    @Test
    void 입력된_값이_1과_2가_아닐_경우() {
        String result = "3";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_영어일_경우() {
        String result = "r";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_10일_경우() {
        String result = "10";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_한글일_경우() {
        String result = "우아한테크코스";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}