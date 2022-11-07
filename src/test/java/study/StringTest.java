package study;


import baseball.Computer;
import baseball.Player;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

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

    @DisplayName("Computer 클래스 - createRandomNumbers() 메서드 테스트")
    @Test
    void createRandomNumbersTest() {
        Computer computer = new Computer();
        List<Integer> list = computer.createRandomNumbers();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
        assertThat(list.stream().distinct().allMatch(n -> list.size() == 3)).isTrue();
    }

    @DisplayName("Player 클래스 - toIntegerPlayerInput() 메서드 테스트")
    @Test
    void toIntegerPlayerInputTest() {
        String inputTest = "352";
        Player player = new Player();
        List<Integer> playerInputNumber =  player.toIntegerPlayerInput(inputTest);
        for (int i = 0; i < 3; i++) {
        assertTrue(playerInputNumber.get(i) instanceof Integer == true);
        }
    }
}
