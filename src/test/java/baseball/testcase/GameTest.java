package baseball.testcase;

import baseball.game.BallMaker;
import baseball.game.BallReader;
import baseball.game.Game;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

public class GameTest extends NsTest {

    @Mock
    BallMaker ballMaker;

    @Mock
    BallReader ballReader;

    @InjectMocks
    Game game;

    @BeforeEach
    void mockSetting() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("BallReader가 게임이 끝났다 판단하면 Game은 종료돼야 한다.")
    @Test
    void BallReader_반환_값에_따른_게임_종료() {
        //given
        when(ballReader.isFinished(anyList(),anyList()))
                .thenReturn(false)
                .thenReturn(true);

        when(ballMaker.getRandomBall())
                .thenReturn(new ArrayList<>());

        when(ballMaker.getUserBall())
                .thenReturn(new ArrayList<>())
                .thenReturn(new ArrayList<>());

        //when
        game.play();

        //then
        assertThat(game.getNumberOfAttempts()).isEqualTo(2);
    }

    @Override
    protected void runMain() {

    }
}
