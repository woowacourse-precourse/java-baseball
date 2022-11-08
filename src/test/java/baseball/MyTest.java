package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest {

    @Test
    void computerBallsList의_길이와_유효성검사() {
        assertThat(Computer.makeBalls())
                .isNotEmpty()
                .doesNotContain(0)
                .size().isEqualTo(Computer.BallsLength);
    }

    @Test
    void computerBallsList가_중복값을_가지지는_않는지_알아본다() {
        for (int i = 0; i < 100; i++) {
            List<Integer> computerBallsList = Computer.makeBalls();
            assertThat(computerBallsList.get(0))
                    .isNotEqualTo(computerBallsList.get(1))
                    .isNotEqualTo(computerBallsList.get(2));
        }
    }

    @Test
    void 사용자의_입력값이_제대로_userBallList로_반환되는지_알아본다() {
        String userInput = "134";
        List<Integer> result = List.of(1, 3, 4);
        assertThat(User.checkUserInput(userInput)).isEqualTo(result);
    }

    @Test
    void 사용자가_볼값을_한자리만_입력했을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_볼값을_두자리만_입력했을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_중복된_볼값을_입력했을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput("232"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_볼값을_입력하지_않았을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_볼값으로_3자리이상을_입력했을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput("2345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_볼값으로_숫자를_입력하지_않았을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput("즐겁다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_볼값에_0이_포함되어_있을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkUserInput("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_질문에_사용자가_값을_입력하지_않았을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkRegameInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_질문에_문자를_입력했을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkRegameInput("하하하"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_질문에_다른숫자를_입력했을때_IllegalArgumentException이_발생하는지_알아본다() {
        assertThatThrownBy(() -> User.checkRegameInput("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
