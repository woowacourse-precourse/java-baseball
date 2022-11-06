package baseball;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    void 유저입력_예외_테스트() {
        List<String> errorCases = List.of(
                "", "1", "12", "1234",
                "112", "121", "111", "211",
                "가나다", "asd", "a가1", "12가",
                "13a", "!@#", " ", " 123",
                "9 7", "\n\t1", "\n123",
                "123\n", "\t132", "1234567489"
        );
        List<String> normalCases = List.of(
                "123", "456", "789",
                "987", "654", "321",
                "231", "132", "312"
        );
        for (String errorCase : errorCases) {
            User wrongInput = new User(errorCase);
            assertThatThrownBy(wrongInput::errorChecking).isInstanceOf(IllegalArgumentException.class);
        }
        for(String normalCase : normalCases){
            User normalInput = new User(normalCase);
            assertThatCode(normalInput::errorChecking).doesNotThrowAnyException();
        }
    }
}
