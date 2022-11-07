package baseball.domain;

import baseball.domain.ball.Balls;
import baseball.domain.ball.service.BallService;
import baseball.global.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallServiceTest {

    AppConfig appConfig = new AppConfig();
    BallService ballService = appConfig.ballService();

    @Test
    @DisplayName("컴퓨터가 랜덤으로 세자리 숫자 만들기")
    void createAnswerBalls() {
        //given
        final List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //when
        final Balls answerBalls = ballService.createAnswerBalls();
        //then
        assertThat(answerBalls.getBalls().size()).isEqualTo(3);
        assertThat(answerBalls.getBallNumbers().stream().filter(integerList::contains).count()).isEqualTo(3L);
    }


    @Test
    @DisplayName("사용자가 입력한 3자리 숫자로 Balls 일급 컬렉션 만들기")
    void createPlayerBalls () {
        //given
        final List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //when
        final Balls playerBalls = ballService.createPlayerBalls("123");
        //then
        assertThat(playerBalls.getBalls().size()).isEqualTo(3);
        assertThat(playerBalls.getBallNumbers().stream().filter(integerList::contains).count()).isEqualTo(3L);
    }

}
