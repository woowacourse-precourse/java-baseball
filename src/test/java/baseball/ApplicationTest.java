package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    public Game makeGameInstance() {
        return new Game();
    }

    public Game playGame() {
        Game game = new Game();
        game.play();

        return game;
    }

    // 기능 요구사항 1
    @Test
    void testFunction1_case1() {
        Computer computer =  new Computer();
        String randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers.length()).isEqualTo(3);
    }

    @Test
    void testFunction1_case2() {
        Computer computer =  new Computer();
        String randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers).isNotEmpty();
    }

    @Test
    void testFunction1_case3() {
        Computer computer =  new Computer();
        String randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers.charAt(0)).isNotEqualTo(randomNumbers.charAt(1));
        assertThat(randomNumbers.charAt(0)).isNotEqualTo(randomNumbers.charAt(2));
        assertThat(randomNumbers.charAt(1)).isNotEqualTo(randomNumbers.charAt(2));
    }

    @Test
    void testFunction1_case4() {
        Computer computer =  new Computer();
        String randomNumbers = computer.getRandomNumbers().toString().replaceAll("[^0-9]", "");
        String pattern = "^[1-9]*$";

        assertThat(Pattern.matches(pattern, randomNumbers)).isTrue();
    }

    // 기능 요구사항 2
    @Test
    void 게임_시작_안내_문구_출력() {
        playGame();
        assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 게임플레이어_숫자_입력_안내_문구_출력() {
        final byte[] buf = String.join("\n", "246", "135", "2").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        playGame().getGamePlayerInput();
        assertThat(output()).contains("숫자를 입력해주세요 :");
    }

    @Test
    void 게임_플레이어_입력_숫자_길이_테스트() {
        String gamePlayerInput = "1234";

        assertThatThrownBy(() -> playGame().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_테스트_1() {
        String gamePlayerInput = "112";

        assertThatThrownBy(() -> playGame().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_테스트_2() {
        String gamePlayerInput = "122";

        assertThatThrownBy(() -> playGame().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_테스트_3() {
        String gamePlayerInput = "222";

        assertThatThrownBy(() -> playGame().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_포함_테스트() {
        String gamePlayerInput = "a12";

        assertThatThrownBy(() -> playGame().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_플레이어_입력_숫자_0포함_테스트() {
        String gamePlayerInput = "012";

        assertThatThrownBy(() -> playGame().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 기능 요구사항 3
    @Test
    void 스트라이크_테스트_1() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "145";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("1스트라이크");
    }

    @Test
    void 스트라이크_테스트_2() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "125";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("2스트라이크");
    }

    @Test
    void 스트라이크_테스트_3() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "123";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("3스트라이크");
//        assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void 볼_테스트_1() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "345";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("1볼");
    }

    @Test
    void 볼_테스트_2() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "315";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("2볼");
    }

    @Test
    void 볼_테스트_3() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "312";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("3볼");
    }

    @Test
    void 볼_스트라이크_테스트_3() {
        String gamePlayerInput = "382";
        String computerRandomNumbers = "382";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("3스트라이크");
    }

    @Test
    void 낫싱_테스트() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "456";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("낫싱");
    }

    // 기능 요구사항 5
    @Test
    void 문자_포함_예외_처리_테스트() {
        String input = " 1234";

        assertThatThrownBy(() -> Exception.hasCharacters(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능요구사항4_문자_포함_예외_테스트() {
        String input = " 1";

        assertThatThrownBy(() -> ExceptionFor4.hasCharacters(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능요구사항4_입력_숫자_테스트() {
        String input = "3";

        assertThatThrownBy(() -> ExceptionFor4.checkYesOrNo(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능요구사항4_입력_숫자_길이_테스트() {
        String input = "31";

        assertThatThrownBy(() -> ExceptionFor4.checkYesOrNo(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    void 기능요구사항4_게임_반복_입력_테스트() {
//        String input = "1";
//
//        assertThatThrownBy(() -> ExceptionFor4.checkYesOrNo(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

}
