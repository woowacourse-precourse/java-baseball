package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameResultTest {

    GameResult gameResult;

    @BeforeEach
    void setUp(){
        gameResult = new GameResult();
    }

    @Nested
    class getResultMessageTest{

        @Test
        void 볼_스트라이크가_아니면_낫싱_리턴(){
            //given
            String expectedMessage = "낫싱";

            //when
            String actualMessage = gameResult.getResultMessage();

            //then
            Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
        }

        @Test
        void 볼_스트라이크_리턴_확인1(){
            //given
            String expectedMessage = "2볼";

            //when
            gameResult.increaseBallCount();
            gameResult.increaseBallCount();
            String actualMessage = gameResult.getResultMessage();

            //then
            Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
        }

        @Test
        void 볼_스트라이크_리턴_확인2(){
            //given
            String expectedMessage = "1스트라이크";

            //when
            gameResult.increaseStrikeCount();
            String actualMessage = gameResult.getResultMessage();

            //then
            Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
        }

        @Test
        void 볼_스트라이크_리턴_확인3(){
            //given
            String expectedMessage = "2볼 1스트라이크";

            //when
            gameResult.increaseBallCount();
            gameResult.increaseBallCount();
            gameResult.increaseStrikeCount();
            String actualMessage = gameResult.getResultMessage();

            //then
            Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }
}