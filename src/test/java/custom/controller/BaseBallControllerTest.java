package custom.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import custom.dto.Response;
import custom.service.BaseBallService;
import org.junit.jupiter.api.Test;

class BaseBallControllerTest {

    private static final String LARGE_INPUT = "125612";
    private static final String CHARACTER_INPUT = "ab1";
    private static final String DUPLICATE_INPUT = "111";
    private static final String INVALID_RETRY_INPUT = "0";


    private final BaseBallService baseBallService = mock(BaseBallService.class);
    private final BaseBallController baseBallController = new BaseBallController(baseBallService);

    @Test
    void matchNumber_validateInputTestWhenLargeInput() {
        // given
        when(baseBallService.matchNumber(anyString())).thenReturn(Response.keepOf("계속"));

        // expect
        assertThatThrownBy(() -> baseBallController.matchNumber(LARGE_INPUT)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void matchNumber_validateInputTestWhenDuplicateInput() {
        // given
        when(baseBallService.matchNumber(anyString())).thenReturn(Response.keepOf("계속"));

        // expect
        assertThatThrownBy(() -> baseBallController.matchNumber(DUPLICATE_INPUT)).isInstanceOf(
            IllegalArgumentException.class);

    }

    @Test
    void matchNumber_validateInputTestWhenCharacterInput() {
        // given
        when(baseBallService.matchNumber(anyString())).thenReturn(Response.keepOf("계속"));

        // expect
        assertThatThrownBy(() -> baseBallController.matchNumber(CHARACTER_INPUT)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void isKeepGo_validateInputTestWhenNotOneOrTwo() {
        // given
        when(baseBallService.isKeepGo(any())).thenReturn(Response.endOf("종료"));

        // expect
        assertThatThrownBy(() -> baseBallController.isKeepGo(INVALID_RETRY_INPUT)).isInstanceOf(
            IllegalArgumentException.class);
    }


}