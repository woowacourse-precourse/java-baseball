package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("유효성 체크 테스트 코드 작성")
public class ValidationTest {
    @DisplayName("유효성 체크를 통해 1이 제대로 입력되었는지 확인")
    @Test
    void givenValidation_when_then(){
        // Given & When
        Validation validation = new Validation();
        int one = validation.validationRestartOrShutDown("1");

        // Then
        assertThat(one).isEqualTo(1);
    }

    @DisplayName("유효성 체크를 통해 2가 제대로 입력되었는지 확인")
    @Test
    void given7_when_then(){
        // Given & When
        Validation validation = new Validation();
        int two = validation.validationRestartOrShutDown("2");

        // Then
        assertThat(two).isEqualTo(2);
    }

    @DisplayName("1 (시작), 2 (종료) 이외의 문자를 입력해서 IllegalArgumentException 을 발생시키는 경우")
    @Test
    void given8_when_then(){
        // Given & When
        Validation validation = new Validation();
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> validation.validationRestartOrShutDown("132312"));
        
        // Then
        assertThat(illegalArgumentException.getMessage()).isEqualTo("1(시작) 또는 2(종료) 가 제대로 입력이 되었는지 확인해주세요.");
    }
}
