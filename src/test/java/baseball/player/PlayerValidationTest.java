package baseball.player;

import baseball.Player;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThatThrownBy(() -> {
            player.wantRestart(illegalUserInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
