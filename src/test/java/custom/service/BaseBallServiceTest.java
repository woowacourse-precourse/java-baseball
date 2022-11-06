package custom.service;

import static org.assertj.core.api.Assertions.assertThat;

import custom.table.Table;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

class BaseBallServiceTest {

    private final Table table = Table.init("");
    private final BaseBallService baseBallService = new BaseBallService(table);

    @Test
    void init_checkTableDataSizeEqualsThree() throws NoSuchFieldException, IllegalAccessException {
        // given

        // when
        baseBallService.init();

        // then
        Field field = table.getClass().getDeclaredField("number");
        field.setAccessible(true);
        String data = (String)field.get(table);
        assertThat(data.length()).isEqualTo(3);
    }

    @Test
    void matchNumber() {
    }

    @Test
    void isKeepGo() {
    }
}