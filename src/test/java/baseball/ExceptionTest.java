package baseball;

import net.bytebuddy.description.modifier.SynchronizationState;
import net.bytebuddy.utility.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    private static User user;
    private static Game game;

    @BeforeEach
    public void beforeEach() {
        game = new Game();
        user = new User();
    }

    @Test
    void 숫자_중복_테스트() {
        String Usernumber = "112";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> user.inputValidation(Usernumber));
        assertThat(e.getMessage()).isEqualTo("잘못된 숫자 입력입니다.");
    }

    @Test
    void 숫자_길이_테스트() {
        String Usernumber = "1234";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> user.inputValidation(Usernumber));
        assertThat(e.getMessage()).isEqualTo("잘못된 숫자 입력입니다.");
    }

    @Test
    void 숫자_길이_테스트2() {
        String Usernumber = "12";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> user.inputValidation(Usernumber));
        assertThat(e.getMessage()).isEqualTo("잘못된 숫자 입력입니다.");

    }

    @Test
    void 숫자_범위_테스트() {
        String Usernumber = "012";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> user.inputValidation(Usernumber));
        assertThat(e.getMessage()).isEqualTo("잘못된 숫자 입력입니다.");
    }

    @Test
    void 종료_여부_입력_테스트() {
        int StartFlag = 3;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> game.checkEndGame(StartFlag));
        assertThat(e.getMessage()).isEqualTo("잘못된 숫자 입력입니다.");
    }

}
