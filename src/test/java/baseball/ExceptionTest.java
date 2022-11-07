package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
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

        assertThatThrownBy(() -> ExceptionFor4.checkInputLength(input))
                .isInstanceOf(IllegalArgumentException.class);
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

        assertThatThrownBy(() -> makeGameInstance().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_테스트_2() {
        String gamePlayerInput = "122";

        assertThatThrownBy(() -> makeGameInstance().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_테스트_3() {
        String gamePlayerInput = "222";

        assertThatThrownBy(() -> makeGameInstance().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_포함_테스트() {
        String gamePlayerInput = "a12";

        assertThatThrownBy(() -> makeGameInstance().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_플레이어_입력_숫자_0포함_테스트() {
        String gamePlayerInput = "012";

        assertThatThrownBy(() -> makeGameInstance().checkGamePlayerNumberInput(gamePlayerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public Game makeGameInstance() {
        return new Game();
    }

    public Game playGame() {
        Game game = new Game();
        game.play();

        return game;
    }
}
