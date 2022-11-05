package baseball.baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class RandomBaseballGameTest {

    private static MockedStatic<Randoms> randomsMock;

    @BeforeAll
    public static void beforeClass() {
        randomsMock = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterClass() {
        randomsMock.close();
    }

    @BeforeEach
    void beforeEach() {
        randomsMock.reset();
    }

    @Test
    @DisplayName("1, 2, 3의 랜덤 Digits이 만들어지는 지 확인")
    void newGame() {
        RandomBaseballGame randomBaseballGame = new RandomBaseballGame(new BaseballGame());
        when(Randoms.pickNumberInRange(1, 9)).thenReturn(1,2,3);

        randomBaseballGame.newGame();
        Digits randomDigits = randomBaseballGame.getRandomDigits();

        assertThat(randomDigits.getList()).isEqualTo(List.of(1,2,3));
    }

    @Test
    @DisplayName("랜덤 Digits과 입력된 Digits이 매칭 되는지 확인")
    void match() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        RandomBaseballGame randomBaseballGame = new RandomBaseballGame(baseballGame);
        when(Randoms.pickNumberInRange(1, 9)).thenReturn(1,2,3);

        Digits playerDigits = new Digits(List.of(2,3,4));
        randomBaseballGame.newGame();
        Digits randomDigits = randomBaseballGame.getRandomDigits();

        // when
        Result resultForRandomAndPlayerDigits = baseballGame.match(playerDigits, randomDigits);
        Result randomBaseballGameResult = randomBaseballGame.match(playerDigits);

        // then
        assertThat(randomBaseballGameResult).isEqualTo(resultForRandomAndPlayerDigits);
    }
}