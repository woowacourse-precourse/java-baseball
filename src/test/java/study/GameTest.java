package study;

import baseball.Game;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class GameTest {

   // @Test
    void 게임_시작_문구_출력() {
        String openingPhrase = "숫자 야구 게임을 시작합니다.";
        Game game = new Game();
        assertThat(openingPhrase).isEqualTo(game.opening());
    }

    //@Test
    void 게임_시작_컴퓨터_랜덤_생성() {
        Game game = new Game();
        game.doGame();
    //    System.out.println(game.getComputerNums().getNums());
    }

  //  @ParameterizedTest
    @ValueSource(strings = {"123\n"})
    void 게임_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Game game = new Game();
        game.doGame();
      //  System.out.println(game.getPlayerNums().getNums());
      //  System.out.println(game.getComputerNums().getNums());
    }

 //   @Test
    void 비교_테스트() {
        Game game = new Game();
        game.doGame();
    }




}