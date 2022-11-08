package baseball;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RestartTest {

    @Test
    void 예외_발생_테스트() {
        List<String> errorCases = List.of(
                "3", "Y", "12", "21", "123",
                "예", "재시작", " ", "", "아니오",
                "!", "@", "#", "N"
        );
        List<String> normalCases = List.of("1", "2");
        for (String errorCase : errorCases) {
            Restart wrongRestart = new Restart(errorCase);
            assertThatThrownBy(wrongRestart::errorChecking).isInstanceOf(IllegalArgumentException.class);
        }
        for (String normalCase : normalCases) {
            Restart normalRestart = new Restart(normalCase);
            assertThatCode(normalRestart::errorChecking).doesNotThrowAnyException();

        }
    }
    @Test
    void 재시작_여부_확인_테스트() {
        Restart agreeToRestart = new Restart("1");
        assertThat(agreeToRestart.wantTerminate()).isEqualTo(false);
        Restart disagreeToRestart = new Restart("2");
        assertThat(disagreeToRestart.wantTerminate()).isEqualTo(true);
    }

}
