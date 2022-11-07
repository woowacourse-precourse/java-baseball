package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void computerSelectNumbers_컴퓨터가_1에서_9까지_서로_다른_임의의_수_3개_선택(){
        assertThat(Game.computerSelectNumbers())
                .isInstanceOf(List.class)
                .hasSize(Game.ANSWER_SIZE)
                .doesNotHaveDuplicates()
                .map(num -> assertThat(num).isBetween(Game.MIN_NUMBER_OF_ANSWER, Game.MAX_NUMBER_OF_ANSWER));
    }

    @Test
    void isInputSizeEqualToAnswerSize_입력의_자리수가_게임정답의_자리수와_동일한_경우_참(){

        List<String> playerInput = List.of("123", "12");
        List<Boolean> expectedOutput = List.of(true, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.isInputSizeEqualToAnswerSize(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void doesNotHaveDuplicateInputElement_입력에_중복된_문자가_없는_경우_참(){
        List<String> playerInput = List.of("123", "112");
        List<Boolean> expectedOutput = List.of(true, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.doesNotHaveDuplicateInputElement(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void hasOnlyNaturalNumberAsInput_입력이_자연수로만_구성된_경우_참(){
        List<String> playerInput = List.of("123", "012", "1a3");
        List<Boolean> expectedOutput = List.of(true, false, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.hasOnlyNaturalNumberAsInput(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void isValidInput_입력이_유효한_경우_참(){
        List<String> playerInput = List.of("012", "112", "12", "1234", "", "123");
        List<Boolean> expectedOutput = List.of(false, false, false, false, false, true);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.isValidInput(input))
                .collect(Collectors.toList());

        assertThat(realOutput).isEqualTo(expectedOutput);
    }

    @Test
    void convertStringToIntegerList_문자열_타입의_입력을_정수형_리스트로_변환(){
        String playerInput = "123";
        List<Integer> expectedOutput = List.of(1, 2, 3);

        List<Integer> realOutput = Player.convertStringToIntegerList(playerInput);

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void countNumbersContainedInAnswer_게임정답에_포함된_입력의_개수_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(7, 2, 1),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(5, 2, 4),
                List.of(9, 8, 7)
        );
        List<Integer> expectedOutput = List.of(2, 2, 3, 1, 0);

        List<Integer> realOutput = playerInput.stream()
                .map(input -> game.countNumbersContainedInAnswer(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void countStrike_스트라이크_개수_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(1, 2, 3),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(3, 2, 1),
                List.of(9, 8, 7)
        );
        List<Integer> expectedOutput = List.of(3, 2, 0, 1, 0);

        List<Integer> realOutput = playerInput.stream()
                .map(input -> game.countStrike(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void getBallStrikeCnt_볼_스트라이크_개수를_리스트로_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(1, 2, 3),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(3, 2, 1),
                List.of(9, 8, 7)
        );
        List<List<Integer>> expectedOutput = List.of(
                List.of(0, 3),
                List.of(0, 2),
                List.of(3, 0),
                List.of(2, 1),
                List.of(0, 0)
        );

        List<List<Integer>> realOutput = playerInput.stream()
                .map(input -> game.getBallStrikeCnt(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);

    }
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
