package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @DisplayName("게임 시작문구 출력 기능")
    @Test
    public void printStrikeTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Game game = new Game();
        assertThat(out.toString()).contains("숫자 야구 게임을 시작합니다.");
    }

    @DisplayName("상대방(컴퓨터)의 수 즉, 난수 생성 기능")
    @Test
    public void randomNumGenerationTest() {
        final Game game = new Game();

        final List<Integer> randomNum = game.opponentNumList;

        assertThat(randomNum.size()).isEqualTo(3);
    }

    @DisplayName("잘못된 값 입력시 예외 처리")
    @Test
    public void exceptionHandlingIncorrectInputValue() {
        final  Game game = new Game();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> game.exceptionHandling("11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("길이가 3인지 검사하는 기능")
    @Test
    public void lenthThreeTest() {
        final  Game game = new Game();
        String num = "123";
        assertThat(game.lengthTree(num)).isTrue();
    }

    @DisplayName("각 자리수의 숫자가 서로 다른지 확인하는 기능")
    @Test
    public void eachDigitNumberDifferentTest() {
        final  Game game = new Game();
        String num = "123";
        assertThat(game.checkingDifferentNumber(num)).isTrue();
    }

    @DisplayName("자릿수 구하는 기능")
    @Test
    public void eachFindDigitsTest() {
        final  Game game = new Game();
        String num = "123";
        game.eachFindDigits(num);
        assertThat(game.inputNumList.size()).isEqualTo(3);
    }

    @DisplayName("동일한 수가 존재하는지 확인하는 기능")
    @Test
    public void sameNumExistTest() {
        final Game game = new Game();

        final List<Integer> num = Arrays.asList(2, 2, 3);
        final int index = 1;

        assertThat(game.sameNumber(index, num)).isTrue();
    }

}
