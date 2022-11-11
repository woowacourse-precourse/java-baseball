package custom.service;

import static org.assertj.core.api.Assertions.assertThat;

import custom.dto.Response;
import custom.service.vo.GameStatus;
import custom.service.vo.ReTry;
import custom.table.Table;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallServiceTest {

    private final Table table = new Table();
    private final BaseBallService baseBallService = new BaseBallService(table);

    @Test
    void init_checkTableDataSizeEqualsThree() throws NoSuchFieldException, IllegalAccessException {
        // given

        // when
        baseBallService.init();

        // then
        Field field = table.getClass().getDeclaredField("number");
        field.setAccessible(true);
        String data = (String) field.get(table);
        assertThat(data.length()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({
        "123, 123, 3스트라이크",
        "124, 678, 낫싱",
        "123, 321, 2볼 1스트라이크",
        "123, 167, 1스트라이크",
        "123, 378, 1볼"
    })
    void matchNumber_dataTest(String number, String input, String output) {
        // given
        table.setNumber(number);

        // when
        Response response = baseBallService.matchNumber(input);

        // then
        assertThat(response.getMessage()).isEqualTo(output);
    }

    @Test
    void isKeepGo_whenInputYesThenReturnKeep() {
        //given
        ReTry input = ReTry.YES;

        // when
        Response response = baseBallService.isKeepGo(input);

        // then
        assertThat(response.getGameStatus()).isEqualTo(GameStatus.KEEP);
    }
}