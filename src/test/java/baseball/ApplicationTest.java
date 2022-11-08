package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
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

    @Test
    void 리스트_변환_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        Method method = game.getClass().getDeclaredMethod("stringToIntegerList", String.class);
        method.setAccessible(true);

        //when
        List<Integer> test = (List<Integer>) method.invoke(game, "123");

        //then
        assertThat(test.get(0)).isEqualTo(1);
    }

    @Test
    void 난수_유효성검증_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        Method method = computer.getClass().getDeclaredMethod("isValidateNumber", List.class);
        method.setAccessible(true);
        //when

        List<Integer> test = new ArrayList<>();
        boolean firstTest;
        test.add(0);
        test.add(2);
        test.add(3);

        firstTest = (boolean) method.invoke(computer, test);

        List<Integer> test2 = new ArrayList<>();
        boolean secondTest;
        test2.add(1);
        test2.add(2);
        test2.add(3);
        test2.add(4);

        secondTest = (boolean) method.invoke(computer, test2);

        //then
        assertThat(firstTest).isEqualTo(false);
        assertThat(secondTest).isEqualTo(false);
    }

    @Test
    void 사용자_입력검증_테스트() {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        //when
        String test = "*()";
        String test2 = "123";
        //then
        assertThatThrownBy(() -> game.validateUserInput(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input is wrong.");

        assertThatCode(() -> game.validateUserInput(test2))
                .doesNotThrowAnyException();
    }

    @Test
    void 사용자_입력길이검증_테스트() {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        //when
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);

        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        test2.add(3);
        test2.add(4);
        //then
        assertThatCode(() -> game.isValidateSize(test1))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> game.isValidateSize(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input size is too long.");
    }

    @Test
    void 사용자_입력범위_테스트() {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        //when
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);

        List<Integer> test2 = new ArrayList<>();
        test2.add(0);
        test2.add(2);
        test2.add(3);
        test2.add(9);
        //then
        assertThatCode(() -> game.isValidateRange(test1))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> game.isValidateRange(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input range is wrong.");
    }

    @Test
    void 사용자_입력중복검증_테스트() {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        //when
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);

        List<Integer> test2 = new ArrayList<>();
        test2.add(3);
        test2.add(3);
        test2.add(9);
        //then
        assertThatCode(() -> game.isDuplicatedNumber(test1))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> game.isDuplicatedNumber(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input is duplicated.");
    }

    @Test
    void 스트라이크검증_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        Method method = game.getClass().getDeclaredMethod("stringToIntegerList", String.class);
        method.setAccessible(true);
        //when
        List<Integer> test = (List<Integer>) method.invoke(game, "123");
        computer.setComputerNumbers(test);

        List<Integer> testStrikeList1 = new ArrayList<>();
        testStrikeList1.add(1);
        testStrikeList1.add(2);
        testStrikeList1.add(3);

        List<Integer> testStrikeList2 = new ArrayList<>();
        testStrikeList2.add(1);
        testStrikeList2.add(5);
        testStrikeList2.add(3);
        //then
        assertThat(game.checkStrikeCount(testStrikeList1)).isEqualTo(3);
        assertThat(game.checkStrikeCount(testStrikeList2)).isEqualTo(2);
    }

    @Test
    void 볼검증_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        Method method = game.getClass().getDeclaredMethod("stringToIntegerList", String.class);
        method.setAccessible(true);
        //when
        List<Integer> test = (List<Integer>) method.invoke(game, "123");
        computer.setComputerNumbers(test);

        List<Integer> testStrikeList1 = new ArrayList<>();
        testStrikeList1.add(1);
        testStrikeList1.add(3);
        testStrikeList1.add(2);

        List<Integer> testStrikeList2 = new ArrayList<>();
        testStrikeList2.add(2);
        testStrikeList2.add(3);
        testStrikeList2.add(1);
        //then
        assertThat(game.checkBallCount(testStrikeList1)).isEqualTo(2);
        assertThat(game.checkBallCount(testStrikeList2)).isEqualTo(3);
    }

    @Test
    void 게임메세지검증_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        Method method = game.getClass().getDeclaredMethod("stringToIntegerList", String.class);
        method.setAccessible(true);
        //when
        List<Integer> testNumber = (List<Integer>) method.invoke(game, "123");
        computer.setComputerNumbers(testNumber);

        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        int testOneStrike = game.checkStrikeCount(test1);
        int testOneball = game.checkBallCount(test1);

        game.setStrike(testOneStrike);
        game.setBall(testOneball);
        //then
        game.gameMessage();
        assertThat(output.toString().trim()).isEqualTo("3스트라이크");
    }

    @Test
    void 게임재시작검증_테스트() {
        //given
        Controller controller = new Controller();
        //when
        String test = "3";
        //then
        assertThatThrownBy(() -> controller.isValidateInput(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input is wrong.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
