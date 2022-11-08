package game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class HintTest extends NsTest {

    @Test
    void 볼의_개수가_증가하는지_확인() {
        //given
        Hint hint = new Hint();
        //when
        hint.incrementBall();
        hint.incrementBall();
        hint.incrementBall();
        //then
        assertThat(hint.getBall()).isEqualTo(3);
    }

    @Test
    void 스트라이크의_개수가_증가하는지_확인() {
        //given
        Hint hint = new Hint();
        //when
        hint.incrementStrike();
        hint.incrementStrike();
        //then
        assertThat(hint.getStrike()).isEqualTo(2);
    }

    @Test
    void 볼의_개수가_초기화되는지_확인() {
        //given
        Hint hint = new Hint();
        hint.incrementBall();
        //when
        hint.clearHint();
        //then
        assertThat(hint.getBall()).isEqualTo(0);
    }

    @Test
    void 스트라이크의_개수가_초기화되는지_확인() {
        //given
        Hint hint = new Hint();
        hint.incrementStrike();
        //when
        hint.clearHint();
        //then
        assertThat(hint.getStrike()).isEqualTo(0);
    }

    @Test
    public void 볼이_3개일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementBall();
        hint.incrementBall();
        hint.incrementBall();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("3볼");
    }

    @Test
    public void 볼이_2개일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementBall();
        hint.incrementBall();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    public void 볼이_1개일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementBall();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("1볼");
    }

    @Test
    public void 볼2개_스트라이크1개_일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementBall();
        hint.incrementBall();
        hint.incrementStrike();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    public void 볼1개_스트라이크2개_일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementBall();
        hint.incrementStrike();
        hint.incrementStrike();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    public void 스트라이크가_3개_일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementStrike();
        hint.incrementStrike();
        hint.incrementStrike();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("3스트라이크");
    }

    @Test
    public void 스트라이크가_2개_일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementStrike();
        hint.incrementStrike();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    public void 스트라이크가_1개_일때_출력() {
        //given
        Hint hint = new Hint();
        hint.incrementStrike();
        //when
        hint.print();
        //then
        assertThat(output()).isEqualTo("1스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}