package baseball;

import baseball.game.domain.Game;
import baseball.game.domain.repository.GameRepository;
import baseball.game.support.Parser;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


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

    @Test
    void 자리수_설정_테스트(){
        GameRepository gameRepository=GameRepository.getInstance();
        gameRepository.setGame();
        Game game= gameRepository.getGame();
        Assertions.assertThat(game.getGameNumber().size()).isEqualTo(3);
    }

    @Test
    void 숫자입력시_자리수_초과_예외처리_테스트(){
        Parser parser=new Parser();
        String input="1234";
        assertThatThrownBy(()->parser.parseClientInput(input,3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자입력시_올바르지_않은_값_예외처리_테스트(){
        Parser parser=new Parser();
        String input="12q";
        assertThatThrownBy(()->parser.parseClientInput(input,3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자입력시_중복된_값_예외처리_테스트(){
        Parser parser=new Parser();
        String input="122";
        assertThatThrownBy(()->parser.parseClientInput(input,3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 스트라이크만_입력_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("189", "136","135","2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크","3스트라이크");
                },
                1, 3, 5
        );
    }
    @Test
    void 볼만_입력_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("819", "316","513","135","2");
                    assertThat(output()).contains("1볼", "2볼","3볼");
                },
                1, 3, 5
        );
    }
    @Test
    void 낫싱_입력_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("789","135","2");
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5
        );
    }
    @Test
    void 스트라이크_볼_입력_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("153","152","135","2");
                    assertThat(output()).contains("2볼 1스트라이크","1볼 1스트라이크");
                },
                1, 3, 5
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
