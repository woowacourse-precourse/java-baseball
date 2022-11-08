package baseball.service;

import baseball.model.Balls;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    void generatePlayerBalls_중복값이_있을_때_예외를_던지는지_테스트() {
        //given
        List<Integer> playerValues = List.of(1, 1, 1);
        //when
        //then
        assertThatThrownBy(() -> {
            Balls balls = new Balls(playerValues);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.");
    }

    @Test
    void generatePlayerBalls_입력_값의_길이가_3이_아닐_경우_예외를_던지는지_테스트() {
        //given
        List<Integer> playerValues = List.of(1, 2);
        //when
        //then
        assertThatThrownBy(() -> {
            Balls balls = new Balls(playerValues);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력된 숫자의 값이 3개가 아닙니다.");
    }

    @Test
    void validateParseStringToInteger_숫자로_변경이_불가능한_문자열이_들어왔을때_예외를_던지는지_테스트() {
        //given
        String playerInput = "12삼";
        //when
        //then
        assertThatThrownBy(() -> {
            try {
                Integer.parseInt(playerInput);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("숫자만 입력이 가능합니다.");
    }

    @Test
    void convertInputToBallList_문자열_입력값이_모두_숫자로_변환이_가능할_때_리스트로_잘_변환되는지_테스트() {
        //given
        String playerInput = "123";
        String[] inputSplits = playerInput.split("");

        List<Integer> playerValues = new ArrayList<>();
        //when
        for (String inputSplit : inputSplits) {
            playerValues.add(Integer.parseInt(inputSplit));
        }
        //then
        assertThat(playerValues.size()).isEqualTo(playerInput.length());
    }

    @Test
    void convertInputToBallList_문자열_입력값이_숫자로_변환이_불가능_할_때_예외를_던지는지_테스트() {
        //given
        String playerInput = "12삼";
        String[] inputSplits = playerInput.split("");

        List<Integer> playerValues = new ArrayList<>();
        //when
        //then
        assertThatThrownBy(() -> {
            for (String inputSplit : inputSplits) {
                try {
                    playerValues.add(Integer.parseInt(inputSplit));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
                }
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("숫자만 입력이 가능합니다.");
    }
}