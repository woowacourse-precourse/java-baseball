package test;

import controller.Controller;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateNumbersTest {

    @Test
    void 자릿수() {
        assertThat(Controller.validateNumbers("")).isEqualTo(false);
        assertThat(Controller.validateNumbers("123")).isEqualTo(true);
        assertThat(Controller.validateNumbers("1234")).isEqualTo(false);
    }

    @Test
    void 범위() {
        assertThat(Controller.validateNumbers("012")).isEqualTo(false);
        assertThat(Controller.validateNumbers("123")).isEqualTo(true);
        assertThat(Controller.validateNumbers("456")).isEqualTo(true);
        assertThat(Controller.validateNumbers("789")).isEqualTo(true);
    }

    @Test
    void 서로_다른_숫자() {
        assertThat(Controller.validateNumbers("111")).isEqualTo(false);
        assertThat(Controller.validateNumbers("112")).isEqualTo(false);
        assertThat(Controller.validateNumbers("211")).isEqualTo(false);
        assertThat(Controller.validateNumbers("212")).isEqualTo(false);
        assertThat(Controller.validateNumbers("321")).isEqualTo(true);
    }

}
