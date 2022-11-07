package baseball.player;

import static org.assertj.core.api.Assertions.*;

import baseball.game.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerValidationTest {

    @ParameterizedTest
    @DisplayName("재시작 여부 확인 시 입력으로 1,2 외의 값 들어올 경우 IllegalArgumentException 발생")
    @ValueSource(strings ={"", " ", "   ","0","3","12","13","23","123","1234","가","가나다","가나다라","a","ab","abc"})
    public void test1(String illegalUserInput) throws Exception{
        //given
        Player player = new Player();
        //when
        //then
        assertThatThrownBy(() -> {
            player.wantRestart(illegalUserInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작을 원하는 경우 true 반환")
    public void test2() throws Exception{
        //given
        Player player = new Player();
        String WANT_RESTART = "1";
        //when
        boolean result = player.wantRestart(WANT_RESTART);
        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("종료를 원하는 경우 false 반환")
    public void test3() throws Exception{
        //given
        Player player = new Player();
        String WANT_EXIT = "2";
        //when
        boolean result = player.wantRestart(WANT_EXIT);
        //then
        assertThat(result).isEqualTo(false);
    }
}
