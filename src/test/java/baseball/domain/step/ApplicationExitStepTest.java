package baseball.domain.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ApplicationExitStep 은 ")
class ApplicationExitStepTest {

    @Test
    @DisplayName("실행할 수 없다.")
    void unExecutable() {
        // given
        ApplicationExitStep applicationExitStep = new ApplicationExitStep();

        // when
        boolean executable = applicationExitStep.executable();

        // then
        assertThat(executable).isFalse();
    }
}