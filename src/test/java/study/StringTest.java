package study;

import baseball.BaseballGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 컴퓨터_랜덤_숫자_생성(){
        List<Integer> num = BaseballGame.ComputerNumGenerator();
        System.out.println("num = " + num);
    }
    
    @Test
    void 길이가_3인지(){
        assertThat(true).isEqualTo(BaseballGame.isThreelen("222"));
        assertThat(false).isEqualTo(BaseballGame.isThreelen("22"));
    }

    @Test
    void 중복이_있는지(){
        assertThat(true).isEqualTo(BaseballGame.isNotDuplicated("123"));
        assertThat(false).isEqualTo(BaseballGame.isNotDuplicated("22"));
    }

    @Test
    void 입력이_1부터9까지_정수인지(){
        assertThat(true).isEqualTo(BaseballGame.isOneNineInt("123"));
        assertThat(false).isEqualTo(BaseballGame.isOneNineInt("220"));
        assertThat(false).isEqualTo(BaseballGame.isOneNineInt("22jj"));
    }

    @Test
    void 사용자_입력_검증(){

        assertThat(Arrays.asList(1, 2, 3)).isEqualTo(BaseballGame.userInputValidator("123"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> BaseballGame.userInputValidator("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> BaseballGame.userInputValidator("103"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> BaseballGame.userInputValidator("hii"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> BaseballGame.userInputValidator("1hi4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void ball_개수(){
        assertThat(0).isEqualTo(BaseballGame.ballCount(Arrays.asList(1, 2, 3),Arrays.asList(1, 2, 3)));
        assertThat(2).isEqualTo(BaseballGame.ballCount(Arrays.asList(1, 2, 3),Arrays.asList(3, 2, 1)));
        assertThat(1).isEqualTo(BaseballGame.ballCount(Arrays.asList(1, 3, 2),Arrays.asList(4, 2, 5)));
    }

    @Test
    void strike_개수(){
        assertThat(3).isEqualTo(BaseballGame.strikeCount(Arrays.asList(1, 2, 3),Arrays.asList(1, 2, 3)));
        assertThat(1).isEqualTo(BaseballGame.strikeCount(Arrays.asList(1, 2, 3),Arrays.asList(3, 2, 1)));
        assertThat(0).isEqualTo(BaseballGame.strikeCount(Arrays.asList(1, 2, 3),Arrays.asList(4, 3, 5)));
    }

    @Test
    void 힌트제공(){
        assertThat(Arrays.asList(0,3)).isEqualTo(BaseballGame.HintProvider(Arrays.asList(1, 2, 3),Arrays.asList(1, 2, 3)));
        assertThat(Arrays.asList(2,1)).isEqualTo(BaseballGame.HintProvider(Arrays.asList(1, 2, 3),Arrays.asList(3, 2, 1)));
        assertThat(Arrays.asList(1,0)).isEqualTo(BaseballGame.HintProvider(Arrays.asList(1, 2, 3),Arrays.asList(4, 3, 5)));
    }

    @Test
    void 게임_반복_여부(){
        assertThat(false).isEqualTo(BaseballGame.exit("1"));
        assertThat(true).isEqualTo(BaseballGame.exit("2"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> BaseballGame.userInputValidator("1hi4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
