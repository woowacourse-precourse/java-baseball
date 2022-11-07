package baseball.service;
import baseball.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void initializeClass(){
        gameService = new GameService();
    }
//
//    @Test
//    void 인덱스값에서_스트라이크면_참(){
//        makeComputer(new int[]{1, 2, 3});
//        gameService.setPlayer("135");
//        assertThat(gameService.isStrike(0)).isTrue();
//    }
//
//    @Test
//    void 인덱스값에서_스트라이크_아니면_거짓(){
//        makeComputer(new int[]{1, 2, 3});
//        gameService.setPlayer("235");
//        assertThat(gameService.isStrike(0)).isFalse();
//    }
//
//    @Test
//    void 인덱스값에서_볼이면_참(){
//        makeComputer(new int[]{1, 2, 3});
//        gameService.setPlayer("135");
//        assertThat(gameService.isBall(1)).isTrue();
//    }
//
//    @Test
//    void 인덱스값에서_볼이_아니면_거짓(){
//        makeComputer(new int[]{1, 2, 3});
//        gameService.setPlayer("235");
//        assertThat(gameService.isBall(2)).isFalse();
//    }
//
//    void makeComputer(int[] arr){
//        gameService.computer = new Computer();
//        gameService.computer.putNumber(arr[0]);
//        gameService.computer.putNumber(arr[1]);
//        gameService.computer.putNumber(arr[2]);
//    }

//    1. 낫싱 (ballCount = 0, strikeCount = 0)
//    2. 1볼 (ballCount = 1, strikeCount = 0)
//    3. 2볼 (ballCOunt = 2, strikeCount = 0)
//    4. 3볼 (ballCOunt = 3, strikeCount = 0)
//    5. 1스트라이크 (ballCount = 0, strikeCount = 1)
//    6. 1볼 1스트라이크 (ballCOunt = 1, strikeCount = 1)
//    7. 2볼 1스트라이크 (ballCount = 2, strikeCount = 1)
//    8. 2스트라이크 (ballCount = 0, strikeCount = 2)
//    9. 3스트라이크 (ballCount = 0, strikeCOunt = 3)

//    결과
//    볼이 0이면 스트라이크는 0~3
//    볼이 1이면 스트라이크 = 0~2
//    그 외에는 볼이 2이거나 3이고 스트라이크는 0이어야 한다.
    @Test
    void 게임_실행시_가능한_결과_내에서만_나온다(){
        playGame();
        if(isZeroBall()) assertZeroBall();
        if(isOneBall()) assertOneBall();
        if(isMoreBalls()) assertMoreBall();
    }

    private void playGame(){
        gameService.initializeScore();
        gameService.setPlayer("123");
        gameService.setComputer();
    }

    private boolean isZeroBall(){
        return gameService.getBallCount() == 0;
    }

    private void assertZeroBall(){
        assertThat(gameService.getStrikeCount())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(3);
    }

    private boolean isOneBall(){
        return gameService.getBallCount() == 1;
    }

    private void assertOneBall(){
        assertThat(gameService.getStrikeCount())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(2);
    }

    private boolean isMoreBalls(){
        return gameService.getBallCount() > 1;
    }

    private void assertMoreBall(){
        assertThat(gameService.getStrikeCount()).isEqualTo(0);
    }

}
